package com.prm.api.controller;

import com.prm.api.entity.Friendship;
import com.prm.api.entity.User;
import com.prm.api.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friendships")
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;

    @PostMapping
    public ResponseEntity<Friendship> addFriendship(@RequestBody Friendship friendship) {
        Friendship savedFriendship = friendshipService.addFriendship(friendship);
        return ResponseEntity.ok(savedFriendship);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFriendship(@RequestBody Friendship friendship) {
        friendshipService.removeFriendship(friendship);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<User>> getFriends(@PathVariable Integer userId) {
        List<User> friends = friendshipService.getFriends(userId);
        return ResponseEntity.ok(friends);
    }
}