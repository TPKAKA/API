package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipId implements Serializable {
    @Column(name = "User")
    private Integer userId;

    @Column(name = "Friend")
    private Integer friendId;
}