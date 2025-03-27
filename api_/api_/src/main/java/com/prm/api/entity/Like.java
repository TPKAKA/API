package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(LikeId.class)
public class Like {
    @Id
    @Column(name = "User") // Khớp với bảng SQLite
    private Integer userId;

    @Id
    @Column(name = "Post") // Khớp với bảng SQLite
    private Integer postId;
}