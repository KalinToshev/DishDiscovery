package com.app.DishDiscovery.models.entities;

import com.app.DishDiscovery.models.enums.CategoryEnums;
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
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, unique = true)
    private CategoryEnums category;

}