package com.prm.api.service;

import com.prm.api.dto.PostDTO;
import com.prm.api.entity.Post;
import com.prm.api.entity.User;
import com.prm.api.repository.PostRepository;
import com.prm.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post addPost(Post post) {
        logger.info("Saving post: {}", post);
        return postRepository.save(post);
    }

    public List<PostDTO> getAllPosts() {
        logger.info("Retrieving all posts");
        List<Post> posts = postRepository.findAll();
        if (posts == null || posts.isEmpty()) {
            logger.warn("No posts found in the database");
            return List.of();
        }
        return posts.stream().map(post -> {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setContent(post.getContent());
            postDTO.setUserId(post.getUserId());
            postDTO.setDateTime(post.getDateTime() != null ? post.getDateTime().toString() : null);
            User user = userRepository.findById(post.getUserId()).orElse(null);
            if (user != null) {
                postDTO.setFirstName(user.getFirstName());
                postDTO.setLastName(user.getLastName());
            }
            return postDTO;
        }).collect(Collectors.toList());
    }

    public PostDTO getPostById(Integer id) {
        logger.info("Retrieving post with ID: {}", id);
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            logger.warn("Post with ID {} not found", id);
            return null;
        }
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setUserId(post.getUserId());
        postDTO.setDateTime(post.getDateTime() != null ? post.getDateTime().toString() : null);
        User user = userRepository.findById(post.getUserId()).orElse(null);
        if (user != null) {
            postDTO.setFirstName(user.getFirstName());
            postDTO.setLastName(user.getLastName());
        }
        return postDTO;
    }
}