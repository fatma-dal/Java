package com.backend.gotogther.repositories;

import java.util.Optional;
import com.backend.gotogther.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPostId(Long postId);
    List<Booking> findByPassengerId(Long passengerId);
    List<Booking> findByPostDriverId(Long driverId);
    Optional<Booking> findByPostIdAndPassengerId(Long postId, Long passengerId);
}