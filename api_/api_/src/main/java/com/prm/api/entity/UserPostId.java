package com.prm.api.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserPostId implements Serializable {
    private Integer userId;
    private Integer postId;

    public UserPostId() {}

    public UserPostId(Integer userId, Integer postId) {
        this.userId = userId;
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPostId that = (UserPostId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, postId);
    }
}