package com.prm.api.service;

import com.prm.api.entity.Like;
import com.prm.api.entity.LikeId;
import com.prm.api.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    public void removeLike(Like like) {
        likeRepository.delete(like);
    }

    public List<Like> getLikesByPostId(Integer postId) {
        return likeRepository.findByPostId(postId);
    }

    public boolean hasLiked(Integer userId, Integer postId) {
        Like like = likeRepository.findById(new LikeId(userId, postId)).orElse(null);
        return like != null;
    }

    public int getLikeCount(Integer postId) {
        List<Like> likes = likeRepository.findByPostId(postId);
        return likes != null ? likes.size() : 0;
    }
}