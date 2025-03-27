package com.prm.api.service;

import com.prm.api.entity.Like; // Explicitly import the correct Like entity
import com.prm.api.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    // Save a Like entity
    public Like saveLike(Like like) { // Ensure the parameter type is com.prm.api.entity.Like
        return likeRepository.save(like);
    }

    // Get Likes by postId
    public List<Like> getLikesByPostId(Integer postId) { // Ensure the return type is List<com.prm.api.entity.Like>
        return likeRepository.findByPostId(postId);
    }
}