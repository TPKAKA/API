package com.prm.api.service;

import com.prm.api.entity.Friendship;
import com.prm.api.entity.User;
import com.prm.api.repository.FriendshipRepository;
import com.prm.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private UserRepository userRepository;

    public Friendship addFriendship(Friendship friendship) {
        return friendshipRepository.save(friendship);
    }

    public void removeFriendship(Friendship friendship) {
        friendshipRepository.delete(friendship);
    }

    public List<User> getFriends(Integer userId) {
        List<Friendship> friendships = friendshipRepository.findByUserId(userId);
        return friendships.stream()
                .map(f -> userRepository.findById(f.getFriendId()).orElse(null))
                .filter(user -> user != null)
                .collect(Collectors.toList());
    }
}