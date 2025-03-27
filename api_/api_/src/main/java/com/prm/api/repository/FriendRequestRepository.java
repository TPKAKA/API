package com.prm.api.repository;

import com.prm.api.entity.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer> {
    List<FriendRequest> findByReceiverIdAndStatus(Integer receiverId, String status);
    List<FriendRequest> findByRequesterIdAndStatus(Integer requesterId, String status);
    FriendRequest findByRequesterIdAndReceiverIdAndStatus(Integer requesterId, Integer receiverId, String status);
}