package com.app.DishDiscovery.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {
    @Column(name = "content", nullable = false, length = 1500)
    private String content;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "creator_id")
    private UserEntity creator;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private RecipeEntity recipe;

}