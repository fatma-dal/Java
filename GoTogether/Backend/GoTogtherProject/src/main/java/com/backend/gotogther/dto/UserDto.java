package com.backend.gotogther.dto;
import com.backend.gotogther.models.Role;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String carLicenseNumber;
    private String carType;
    private String carColor;
    private String carPlateNumber;
}
