package com.backend.gotogther.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BecomeDriverRequest {
    private String carLicenseNumber;
    private String carType;
    private String carColor;
    private String carPlateNumber;
}