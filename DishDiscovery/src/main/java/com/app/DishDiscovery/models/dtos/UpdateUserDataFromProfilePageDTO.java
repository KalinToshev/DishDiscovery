package com.app.DishDiscovery.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDataFromProfilePageDTO {
    private String username;

    private String email;

    private String fullName;
}
