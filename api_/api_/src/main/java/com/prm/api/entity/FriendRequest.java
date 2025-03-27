package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "friend_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "requester_id")
    private Integer requesterId;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private String createdAt;
}