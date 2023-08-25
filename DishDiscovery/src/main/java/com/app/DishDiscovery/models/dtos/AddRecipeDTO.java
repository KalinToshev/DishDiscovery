package com.app.DishDiscovery.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static com.app.DishDiscovery.utils.AddRecipeValidationMessages.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRecipeDTO {
    @NotBlank(message = TITLE_NOT_BLANK_MESSAGE)
    @Size(min = 3, max = 50, message = TITLE_SIZE_MESSAGE)
    private String title;

    @NotBlank(message = DESCRIPTION_NOT_BLANK_MESSAGE)
    @Size(min = 10, max = 500, message = DESCRIPTION_SIZE_MESSAGE)
    private String description;

    @NotBlank(message = CATEGORY_NOT_BLANK_MESSAGE)
    private String category;

    @NotBlank(message = DIFFICULTY_NOT_BLANK_MESSAGE)
    private String difficulty;

    @NotBlank(message = IMAGE1_URL_NOT_BLANK_MESSAGE)
    private String image1Url;

    @NotBlank(message = IMAGE2_URL_NOT_BLANK_MESSAGE)
    private String image2Url;

    @NotBlank(message = IMAGE3_URL_NOT_BLANK_MESSAGE)
    private String image3Url;

    @NotBlank(message = IMAGE4_URL_NOT_BLANK_MESSAGE)
    private String image4Url;

    @NotBlank(message = IMAGE5_URL_NOT_BLANK_MESSAGE)
    private String image5Url;

    @NotBlank(message = CREATED_AT_NOT_BLANK_MESSAGE)
    private Date createdAt = new Date();
}
