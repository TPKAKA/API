package com.prm.api.service;

import com.prm.api.entity.Like;
import com.prm.api.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public List<Like> getLikesByPostId(Integer postId) {
        return likeRepository.findByPostId(postId);
    }
}