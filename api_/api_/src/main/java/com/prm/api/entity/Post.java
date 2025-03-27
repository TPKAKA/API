package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Content")
    private String content;

    @Column(name = "User")
    private Integer userId;

    @Column(name = "DateTime")
    private String dateTime;

    @Column(name = "image_path")
    private String imagePath;
}