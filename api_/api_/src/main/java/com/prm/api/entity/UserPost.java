package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "User_Posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(UserPostId.class)
public class UserPost {
    @Id
    @Column(name = "User")
    private Integer userId;

    @Id
    @Column(name = "Post")
    private Integer postId;
}