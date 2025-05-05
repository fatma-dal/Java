package com.backend.gotogther.services;


import com.backend.gotogther.models.PostStatus;

import com.backend.gotogther.dto.PostDto;
import com.backend.gotogther.dto.PostResponse;
import com.backend.gotogther.models.Post;
import com.backend.gotogther.models.Role;
import com.backend.gotogther.models.User;
import com.backend.gotogther.repositories.PostRepository;
import com.backend.gotogther.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    
    public PostResponse createPost(PostDto postDto, Long userId) {
        User driver = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        if (driver.getRole() != Role.DRIVER) {
            throw new IllegalStateException("Only drivers can create posts");
        }
        
        Post post = Post.builder()
                .departure(postDto.getDeparture())
                .destination(postDto.getDestination())
                .departureTime(postDto.getDepartureTime())
                .description(postDto.getDescription())
                .availableSeats(postDto.getAvailableSeats())
                .luggageSize(postDto.getLuggageSize())
                .pricePerSeat(postDto.getPricePerSeat())
                .driver(driver)
                .status(PostStatus.ACTIVE)
                .build();
        
        postRepository.save(post);
        return mapToPostResponse(post);
    }
    
    public List<PostResponse> getAllActivePosts() {
        return postRepository.findActivePosts(LocalDateTime.now()).stream()
                .map(this::mapToPostResponse)
                .collect(Collectors.toList());
    }
    
    public List<PostResponse> getPostsByDriver(Long driverId) {
        return postRepository.findByDriverId(driverId).stream()
                .map(this::mapToPostResponse)
                .collect(Collectors.toList());
    }
    
    public PostResponse updatePost(Long postId, PostDto postDto, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new UsernameNotFoundException("Post not found"));
        
        if (!post.getDriver().getId().equals(userId)) {
            throw new IllegalStateException("Only the post creator can update the post");
        }
        
        post.setDeparture(postDto.getDeparture());
        post.setDestination(postDto.getDestination());
        post.setDepartureTime(postDto.getDepartureTime());
        post.setDescription(postDto.getDescription());
        post.setAvailableSeats(postDto.getAvailableSeats());
        post.setLuggageSize(postDto.getLuggageSize());
        post.setPricePerSeat(postDto.getPricePerSeat());
        
        postRepository.save(post);
        return mapToPostResponse(post);
    }
    
    public void deletePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new UsernameNotFoundException("Post not found"));
        
        if (!post.getDriver().getId().equals(userId)) {
            throw new IllegalStateException("Only the post creator can delete the post");
        }
        
        postRepository.delete(post);
    }
    
    public PostResponse mapToPostResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .departure(post.getDeparture())
                .destination(post.getDestination())
                .departureTime(post.getDepartureTime().toString())
                .description(post.getDescription())
                .availableSeats(post.getAvailableSeats())
                .luggageSize(post.getLuggageSize().name())
                .pricePerSeat(post.getPricePerSeat())
                .driver(userService.mapToUserDto(post.getDriver()))
                .status(post.getStatus().name())
                .build();
    }
}