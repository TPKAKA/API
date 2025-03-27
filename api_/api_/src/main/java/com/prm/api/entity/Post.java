package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") // Khớp với bảng SQLite
    private Integer id;

    @Column(name = "Content")
    private String content;

    @Column(name = "User") // Khớp với bảng SQLite
    private Integer userId;

    @Column(name = "DateTime")
    private LocalDateTime dateTime;
}