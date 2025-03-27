package com.prm.api.service;

import com.prm.api.dto.PostDTO;
import com.prm.api.entity.Post;
import com.prm.api.entity.User;
import com.prm.api.repository.PostRepository;
import com.prm.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> {
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setContent(post.getContent());
            postDTO.setUserId(post.getUserId());
            postDTO.setDateTime(post.getDateTime().toString());
            User user = userRepository.findById(post.getUserId()).orElse(null);
            if (user != null) {
                postDTO.setFirstName(user.getFirstName());
                postDTO.setLastName(user.getLastName());
            }
            return postDTO;
        }).collect(Collectors.toList());
    }

    public PostDTO getPostById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return null;
        }
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setUserId(post.getUserId());
        postDTO.setDateTime(post.getDateTime().toString());
        User user = userRepository.findById(post.getUserId()).orElse(null);
        if (user != null) {
            postDTO.setFirstName(user.getFirstName());
            postDTO.setLastName(user.getLastName());
        }
        return postDTO;
    }
}