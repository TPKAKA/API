package com.prm.api.repository;

import com.prm.api.entity.Friendship;
import com.prm.api.entity.FriendshipId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, FriendshipId> {
    List<Friendship> findByUserId(Integer userId);
}