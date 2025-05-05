package com.backend.gotogther.services;


import com.backend.gotogther.dto.*;
import com.backend.gotogther.models.*;
import com.backend.gotogther.repositories.BookingRepository;
import com.backend.gotogther.repositories.PostRepository;
import com.backend.gotogther.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    
    private final BookingRepository bookingRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PostService postService;
    
    public BookingResponse createBooking(BookingRequest request, Long passengerId) {
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new UsernameNotFoundException("Post not found"));
        
        User passenger = userRepository.findById(passengerId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        if (post.getDriver().getId().equals(passengerId)) {
            throw new IllegalStateException("Driver cannot book their own trip");
        }
        
        if (post.getAvailableSeats() < request.getSeatsBooked()) {
            throw new IllegalStateException("Not enough available seats");
        }
        
        Booking booking = Booking.builder()
                .post(post)
                .passenger(passenger)
                .status(BookingStatus.PENDING)
                .seatsBooked(request.getSeatsBooked())
                .notes(request.getNotes())
                .build();
        
        bookingRepository.save(booking);
        return mapToBookingResponse(booking);
    }
    
    public List<BookingResponse> getBookingsByPassenger(Long passengerId) {
        return bookingRepository.findByPassengerId(passengerId).stream()
                .map(this::mapToBookingResponse)
                .collect(Collectors.toList());
    }
    
    public List<BookingResponse> getBookingsForDriver(Long driverId) {
        return bookingRepository.findByPostDriverId(driverId).stream()
                .map(this::mapToBookingResponse)
                .collect(Collectors.toList());
    }
    
    public BookingResponse updateBookingStatus(Long bookingId, BookingStatusUpdateRequest request, Long userId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new UsernameNotFoundException("Booking not found"));
        
        if (!booking.getPost().getDriver().getId().equals(userId)) {
            throw new IllegalStateException("Only the driver can update booking status");
        }
        
        BookingStatus newStatus = BookingStatus.valueOf(request.getStatus());
        booking.setStatus(newStatus);
        
        if (newStatus == BookingStatus.ACCEPTED) {
            Post post = booking.getPost();
            post.setAvailableSeats(post.getAvailableSeats() - booking.getSeatsBooked());
            postRepository.save(post);
        }
        
        bookingRepository.save(booking);
        return mapToBookingResponse(booking);
    }
    
    public void cancelBooking(Long bookingId, Long userId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new UsernameNotFoundException("Booking not found"));
        
        if (!booking.getPassenger().getId().equals(userId)) {
            throw new IllegalStateException("Only the passenger can cancel the booking");
        }
        
        if (booking.getStatus() == BookingStatus.ACCEPTED) {
            Post post = booking.getPost();
            post.setAvailableSeats(post.getAvailableSeats() + booking.getSeatsBooked());
            postRepository.save(post);
        }
        
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }
    
    private BookingResponse mapToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .post(postService.mapToPostResponse(booking.getPost()))
                .passenger(userService.mapToUserDto(booking.getPassenger()))
                .status(booking.getStatus().name())
                .seatsBooked(booking.getSeatsBooked())
                .notes(booking.getNotes())
                .build();
    }
}