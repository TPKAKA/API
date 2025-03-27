package com.prm.api.dto;

import lombok.Data;

@Data
public class PostDTO {
    private Integer id;
    private String content;
    private Integer userId;
    private String dateTime;
    private String firstName;
    private String lastName;
    private String imagePath;
    private String avatarPath;
    private Integer likeCount;
}