package com.backend.gotogther.dto;

import com.backend.gotogther.models.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    @Size(min = 8)
    private String confirmPassword;
    private Role role;
    
    // Driver-specific fields
    private String carLicenseNumber;
    private String carType;
    private String carColor;
    private String carPlateNumber;
}

