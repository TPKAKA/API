package com.prm.api.controller;

import com.prm.api.entity.Like; // Correct import
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
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like savedLike = likeService.saveLike(like); // Should now resolve correctly
        return ResponseEntity.ok(savedLike);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable Integer postId) {
        List<Like> likes = likeService.getLikesByPostId(postId); // Should now resolve correctly
        return ResponseEntity.ok(likes);
    }
}