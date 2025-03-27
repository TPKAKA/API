package com.prm.api.service;

import com.prm.api.entity.FriendRequest;
import com.prm.api.entity.Friendship;
import com.prm.api.repository.FriendRequestRepository;
import com.prm.api.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendRequestService {
    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendshipRepository friendshipRepository;

    public FriendRequest addFriendRequest(FriendRequest friendRequest) {
        friendRequest.setStatus("pending");
        return friendRequestRepository.save(friendRequest);
    }

    public FriendRequest acceptFriendRequest(Integer requesterId, Integer receiverId) {
        FriendRequest request = friendRequestRepository.findByRequesterIdAndReceiverIdAndStatus(requesterId, receiverId, "pending");
        if (request != null) {
            request.setStatus("accepted");
            friendRequestRepository.save(request);

            // Thêm vào bảng Friendships
            Friendship friendship = new Friendship(requesterId, receiverId);
            friendshipRepository.save(friendship);
            Friendship reverseFriendship = new Friendship(receiverId, requesterId);
            friendshipRepository.save(reverseFriendship);
        }
        return request;
    }

    public FriendRequest rejectFriendRequest(Integer requesterId, Integer receiverId) {
        FriendRequest request = friendRequestRepository.findByRequesterIdAndReceiverIdAndStatus(requesterId, receiverId, "pending");
        if (request != null) {
            request.setStatus("rejected");
            return friendRequestRepository.save(request);
        }
        return null;
    }

    public List<FriendRequest> getPendingFriendRequests(Integer receiverId) {
        return friendRequestRepository.findByReceiverIdAndStatus(receiverId, "pending");
    }

    public List<FriendRequest> getSentFriendRequests(Integer requesterId) {
        return friendRequestRepository.findByRequesterIdAndStatus(requesterId, "pending");
    }

    public boolean hasPendingFriendRequest(Integer requesterId, Integer receiverId) {
        FriendRequest request = friendRequestRepository.findByRequesterIdAndReceiverIdAndStatus(requesterId, receiverId, "pending");
        return request != null;
    }
}