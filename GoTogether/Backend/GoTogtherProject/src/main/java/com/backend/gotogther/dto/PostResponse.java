package com.backend.gotogther.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;
    private String departure;
    private String destination;
    private String departureTime;
    private String description;
    private int availableSeats;
    private String luggageSize;
    private double pricePerSeat;
    private UserDto driver;
    private String status;
}
