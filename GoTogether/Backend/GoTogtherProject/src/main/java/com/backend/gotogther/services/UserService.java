package com.backend.gotogther.services;

import com.backend.gotogther.dto.BecomeDriverRequest;
import com.backend.gotogther.dto.UserDto;
import com.backend.gotogther.models.Role;
import com.backend.gotogther.models.User;
import com.backend.gotogther.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
   

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .carLicenseNumber(user.getCarLicenseNumber())
                .carType(user.getCarType())
                .carColor(user.getCarColor())
                .carPlateNumber(user.getCarPlateNumber())
                .build();
    }


    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return mapToUserDto(user);
    }
    
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
    
    public UserDto updateUserRole(Long userId, Role newRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setRole(newRole);
        userRepository.save(user);
        return mapToUserDto(user);
    }
    
    public UserDto becomeDriver(Long userId, BecomeDriverRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        user.setRole(Role.DRIVER);
        user.setCarLicenseNumber(request.getCarLicenseNumber());
        user.setCarType(request.getCarType());
        user.setCarColor(request.getCarColor());
        user.setCarPlateNumber(request.getCarPlateNumber());
        
        userRepository.save(user);
        return mapToUserDto(user);
    }
    
    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .carLicenseNumber(user.getCarLicenseNumber())
                .carType(user.getCarType())
                .carColor(user.getCarColor())
                .carPlateNumber(user.getCarPlateNumber())
                .build();
    }
}