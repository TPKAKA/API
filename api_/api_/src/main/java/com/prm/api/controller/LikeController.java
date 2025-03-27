package com.prm.api.controller;

import com.prm.api.entity.Like;
import com.prm.api.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> addLike(@RequestBody Like like) {
        Like savedLike = likeService.addLike(like);
        return ResponseEntity.ok(savedLike);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeLike(@RequestBody Like like) {
        likeService.removeLike(like);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable Integer postId) {
        List<Like> likes = likeService.getLikesByPostId(postId);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/has-liked/{userId}/{postId}")
    public ResponseEntity<Boolean> hasLiked(@PathVariable Integer userId, @PathVariable Integer postId) {
        boolean hasLiked = likeService.hasLiked(userId, postId);
        return ResponseEntity.ok(hasLiked);
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Integer> getLikeCount(@PathVariable Integer postId) {
        int likeCount = likeService.getLikeCount(postId);
        return ResponseEntity.ok(likeCount);
    }
}