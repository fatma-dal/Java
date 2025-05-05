package com.backend.gotogther.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingStatusUpdateRequest {
    private String status; // "ACCEPTED", "REJECTED", etc.
}