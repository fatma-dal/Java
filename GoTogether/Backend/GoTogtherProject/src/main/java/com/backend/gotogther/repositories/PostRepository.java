package com.backend.gotogther.repositories;


import com.backend.gotogther.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByDepartureAndDestinationAndDepartureTimeAfter(
            String departure, String destination, LocalDateTime departureTime);
    
    List<Post> findByDriverId(Long driverId);
    
    @Query("SELECT p FROM Post p WHERE p.departureTime > :now AND p.status = 'ACTIVE'")
    List<Post> findActivePosts(@Param("now") LocalDateTime now);
}