package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Friendships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(FriendshipId.class)
public class Friendship {
    @Id
    @Column(name = "User") // Khớp với bảng SQLite
    private Integer userId;

    @Id
    @Column(name = "Friend") // Khớp với bảng SQLite
    private Integer friendId;
}