package com.prm.api.controller;

import com.prm.api.entity.UserPost;
import com.prm.api.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-posts")
public class UserPostController {
    @Autowired
    private UserPostService userPostService;

    @PostMapping
    public ResponseEntity<UserPost> addUserPost(@RequestBody UserPost userPost) {
        UserPost savedUserPost = userPostService.saveUserPost(userPost);
        return ResponseEntity.ok(savedUserPost);
    }

    @GetMapping
    public ResponseEntity<List<UserPost>> getAllUserPosts() {
        List<UserPost> userPosts = userPostService.getAllUserPosts();
        return ResponseEntity.ok(userPosts);
    }
}