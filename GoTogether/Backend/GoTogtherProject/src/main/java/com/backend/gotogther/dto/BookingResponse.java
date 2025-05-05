package com.backend.gotogther.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Long id;
    private PostResponse post;
    private UserDto passenger;
    private String status;
    private int seatsBooked;
    private String notes;
}