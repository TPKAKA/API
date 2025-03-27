package com.prm.api.repository;

import com.prm.api.entity.Like;
import com.prm.api.entity.LikeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, LikeId> {
    List<Like> findByPostId(Integer postId);
}