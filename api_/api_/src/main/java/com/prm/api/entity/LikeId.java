package com.prm.api.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {
    @Column(name = "User")
    private Integer userId;

    @Column(name = "Post")
    private Integer postId;
}