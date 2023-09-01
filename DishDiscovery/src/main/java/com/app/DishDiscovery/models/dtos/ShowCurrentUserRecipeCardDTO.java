package com.app.DishDiscovery.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowCurrentUserRecipeCardDTO {
    private Long id;

    private String title;

    private String image1Url;
}
