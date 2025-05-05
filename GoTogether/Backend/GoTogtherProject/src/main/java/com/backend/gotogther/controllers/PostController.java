package com.backend.gotogther.controllers;

import com.backend.gotogther.dto.PostDto;
import com.backend.gotogther.dto.PostResponse;
import com.backend.gotogther.models.User;
import com.backend.gotogther.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;
    
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllActivePosts() {
        return ResponseEntity.ok(postService.getAllActivePosts());
    }
    
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<PostResponse>> getPostsByDriver(@PathVariable Long driverId) {
        return ResponseEntity.ok(postService.getPostsByDriver(driverId));
    }
    
    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @RequestBody PostDto postDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = ((User) userDetails).getId();
        return ResponseEntity.ok(postService.createPost(postDto, userId));
    }
    
    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable Long postId,
            @RequestBody PostDto postDto,
            @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = ((User) userDetails).getId();
        return ResponseEntity.ok(postService.updatePost(postId, postDto, userId));
    }
    
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(
            @PathVariable Long postId,
            @AuthenticationPrincipal UserDetails userDetails) {
        Long userId = ((User) userDetails).getId();
        postService.deletePost(postId, userId);
        return ResponseEntity.noContent().build();
    }
}