package com.app.DishDiscovery.models.entities;

import com.app.DishDiscovery.models.enums.DifficultyEnums;
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
@Table(name = "difficulties")
public class DifficultyEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false, unique = true)
    private DifficultyEnums difficulty;

}