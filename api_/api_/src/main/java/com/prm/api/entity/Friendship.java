package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;
 // Use jakarta.persistence instead of javax.persistence

@Entity // Add @Entity annotation
@Table(name = "Friendships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(FriendshipId.class)
public class Friendship { // Renamed from FriendShip to Friendship
    @Id
    @Column(name = "User")
    private Integer userId;

    @Id
    @Column(name = "Friend")
    private Integer friendId;
}