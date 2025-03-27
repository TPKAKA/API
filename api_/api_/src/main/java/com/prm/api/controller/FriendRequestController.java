package com.prm.api.controller;

import com.prm.api.entity.FriendRequest;
import com.prm.api.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friend-requests")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping
    public ResponseEntity<FriendRequest> addFriendRequest(@RequestBody FriendRequest friendRequest) {
        FriendRequest savedRequest = friendRequestService.addFriendRequest(friendRequest);
        return ResponseEntity.ok(savedRequest);
    }

    @PutMapping("/accept/{requesterId}/{receiverId}")
    public ResponseEntity<FriendRequest> acceptFriendRequest(@PathVariable Integer requesterId, @PathVariable Integer receiverId) {
        FriendRequest updatedRequest = friendRequestService.acceptFriendRequest(requesterId, receiverId);
        if (updatedRequest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRequest);
    }

    @PutMapping("/reject/{requesterId}/{receiverId}")
    public ResponseEntity<FriendRequest> rejectFriendRequest(@PathVariable Integer requesterId, @PathVariable Integer receiverId) {
        FriendRequest updatedRequest = friendRequestService.rejectFriendRequest(requesterId, receiverId);
        if (updatedRequest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping("/pending/{receiverId}")
    public ResponseEntity<List<FriendRequest>> getPendingFriendRequests(@PathVariable Integer receiverId) {
        List<FriendRequest> requests = friendRequestService.getPendingFriendRequests(receiverId);
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/sent/{requesterId}")
    public ResponseEntity<List<FriendRequest>> getSentFriendRequests(@PathVariable Integer requesterId) {
        List<FriendRequest> requests = friendRequestService.getSentFriendRequests(requesterId);
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/has-pending/{requesterId}/{receiverId}")
    public ResponseEntity<Boolean> hasPendingFriendRequest(@PathVariable Integer requesterId, @PathVariable Integer receiverId) {
        boolean hasPending = friendRequestService.hasPendingFriendRequest(requesterId, receiverId);
        return ResponseEntity.ok(hasPending);
    }
}