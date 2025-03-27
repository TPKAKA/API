package com.prm.api.service;

import com.prm.api.entity.UserPost;
import com.prm.api.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostService {
    @Autowired
    private UserPostRepository userPostRepository;

    public UserPost saveUserPost(UserPost userPost) {
        return userPostRepository.save(userPost);
    }

    public List<UserPost> getAllUserPosts() {
        return userPostRepository.findAll();
    }
}