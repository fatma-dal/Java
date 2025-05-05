package com.backend.gotogther.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.backend.gotogther.models.PostStatus;
import com.backend.gotogther.models.LuggageSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "posts")
@Builder
//@NoArgsConstructor
public class Post {

	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Departure location cannot be blank")
    @Size(max = 100, message = "Departure location must not exceed 100 characters")
    private String departure;
    
    @NotBlank(message = "Destination cannot be blank")
    @Size(max = 100, message = "Destination must not exceed 100 characters")
    private String destination;
    
    @Future(message = "Departure date must be in the future")
    private LocalDateTime departureTime;
    
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;
    
    @Min(value = 1, message = "At least one seat must be available")
    private int availableSeats;
    
    @Enumerated(EnumType.STRING)
    private LuggageSize luggageSize;
    
    @PositiveOrZero(message = "Price cannot be negative")
    private double pricePerSeat;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;
    
    @Enumerated(EnumType.STRING)
    private PostStatus status = PostStatus.ACTIVE;
}



