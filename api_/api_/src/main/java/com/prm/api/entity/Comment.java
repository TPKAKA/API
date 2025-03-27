package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Content")
    private String content;

    @Column(name = "Post")
    private Integer postId;

    @Column(name = "User")
    private Integer userId;

    @Column(name = "DateTime")
    private String dateTime;
}