package com.app.DishDiscovery.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "recipes")
public class RecipeEntity extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, length = 3500)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "difficulty_id")
    private DifficultyEntity difficulty;

    @Column(name = "image_1_url", nullable = false)
    private String image1Url;

    @Column(name = "image_2_url", nullable = false)
    private String image2Url;

    @Column(name = "image_3_url", nullable = false)
    private String image3Url;

    @Column(name = "image_4_url", nullable = false)
    private String image4Url;

    @Column(name = "image_5_url", nullable = false)
    private String image5Url;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false)
    private Date createdAt = new Date();

}