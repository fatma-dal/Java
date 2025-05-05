package com.backend.gotogther.controllers;

import java.util.List;
import com.backend.gotogther.models.Role;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.backend.gotogther.services.AuthenticationService;
import com.backend.gotogther.services.UserService;
import com.backend.gotogther.dto.AuthenticationResponse;
import com.backend.gotogther.dto.BecomeDriverRequest;
import com.backend.gotogther.dto.RegisterRequest;
import com.backend.gotogther.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class userController {
    
    private final UserService userService;
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }
    
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        UserDto userDto = userService.getUserByEmail(userDetails.getUsername());
        return ResponseEntity.ok(userDto);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @PostMapping("/{userId}/become-driver")
    public ResponseEntity<UserDto> becomeDriver(
            @PathVariable Long userId,
            @RequestBody BecomeDriverRequest request) {
        return ResponseEntity.ok(userService.becomeDriver(userId, request));
    }
    
    @PutMapping("/{userId}/role")
    public ResponseEntity<UserDto> updateUserRole(
            @PathVariable Long userId,
            @RequestParam Role role) {
        return ResponseEntity.ok(userService.updateUserRole(userId, role));
    }
}

