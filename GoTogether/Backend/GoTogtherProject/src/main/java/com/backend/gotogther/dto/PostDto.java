package com.backend.gotogther.dto;
import com.backend.gotogther.models.LuggageSize;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    
    @NotBlank
    private String departure;
    
    @NotBlank
    private String destination;
    
    @Future
    private LocalDateTime departureTime;
    
    private String description;
    
    @Min(1)
    private int availableSeats;
    
    private LuggageSize luggageSize;
    
    @PositiveOrZero
    private double pricePerSeat;
}