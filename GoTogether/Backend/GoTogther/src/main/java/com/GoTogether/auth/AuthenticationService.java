package com.GoTogether.auth;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.GoTogether.config.JwtService;
import com.GoTogether.models.Role;
import com.GoTogether.models.User;
import com.GoTogether.repositories.UserRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    /**
     * This service class handles the business logic for user authentication and registration.
     */
    private UserRepository userRepository;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /**
     * Registers a new user. If the email already exists, returns a CONFLICT status.
     * Otherwise, generates an auto-generated password, saves the new user and email him containing his details, and
     * returns an authentication response with a JWT token and user role.
     *
     * @param request containing user details
     * @return ResponseEntity containing the authentication response and HTTP status
     */
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {
        Optional<User> opUser = userRepository.findByEmail(request.getEmail());
        if (opUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            User user = ( (Object) User.builder())
					.username(request.getUsername())
					.email(request.getEmail())
					.password(passwordEncoder.encode(request.getPassword()))
					.role(request.getRole())
					.build();
            System.out.println(user.toString());
            userRepository.save(user);
            String jwtToken = jwtService.generateToken(user, user.getId());
            Role role = user.getRole();
            String fullName = user.getUsername();
            String email = user.getEmail();
            return new ResponseEntity<>(AuthenticationResponse.builder().role(role)
                    .fullName(fullName)
                    .email(email)
                    .token(jwtToken)
                    .build(),
                    HttpStatus.OK);
        }
    }
    /*
     * Authenticates a user with the provided email and password. If authentication is
     * successful, retrieves the user details, generates a JWT token, and returns
     * an authentication response with the user's role and the token.
     *
     * @param request containing email and password
     * @return AuthenticationResponse containing the user's role and JWT token
     */
    /**
     * Authenticates a user with the provided email and password. If authentication is
     * successful, retrieves the user details, generates a JWT token, and returns
     * an authentication response with the user's role and the token.
     *
     * @param request containing email and password
     * @return AuthenticationResponse containing the user's role and JWT token
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Authenticate the user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Fetch user from the database
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        // Generate JWT token
        String jwtToken = jwtService.generateToken(user, user.getId());

        // Return response with token, role, and user info
        return AuthenticationResponse.builder()
                .role(user.getRole())
                .fullName(user.getUsername())
                .email(user.getEmail())
                .token(jwtToken)
                .build();
    }

}