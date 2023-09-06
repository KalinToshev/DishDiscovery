package com.app.DishDiscovery.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecipeDTO {
    private String title;
    private String description;
    private String categoryName;
    private String difficultyName;
    private String image1Url;
    private String image2Url;
    private String image3Url;
    private String image4Url;
    private String image5Url;
    private Date createdAt;
    private String authorName;
}
