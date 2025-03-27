package com.prm.api.controller;

import com.prm.api.entity.Comment;
import com.prm.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/by-post")
    public List<Comment> getCommentsByPostId(@RequestParam("postId") Integer postId) {
        return commentService.getCommentsByPostId(postId);
    }
}