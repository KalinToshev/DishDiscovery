package com.app.DishDiscovery.services.difficulty;

import com.app.DishDiscovery.models.entities.DifficultyEntity;

public interface DifficultyService {
    void initDifficulties();

    DifficultyEntity getDifficultyByName(String name);
}
