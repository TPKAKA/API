package com.prm.api.repository;

import com.prm.api.entity.UserPost;
import com.prm.api.entity.UserPostId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepository extends JpaRepository<UserPost, UserPostId> {
}