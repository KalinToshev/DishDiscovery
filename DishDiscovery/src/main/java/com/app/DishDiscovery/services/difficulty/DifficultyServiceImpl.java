package com.app.DishDiscovery.services.difficulty;

import com.app.DishDiscovery.models.entities.DifficultyEntity;
import com.app.DishDiscovery.models.enums.DifficultyEnums;
import com.app.DishDiscovery.repositories.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DifficultyServiceImpl implements DifficultyService {
    private final DifficultyRepository difficultyRepository;

    @Autowired
    public DifficultyServiceImpl(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public void initDifficulties() {
        if (difficultyRepository.count() == 0) {
            Arrays.stream(DifficultyEnums.values())
                    .forEach(difficulty_ -> {
                        DifficultyEntity difficulty = new DifficultyEntity(difficulty_);
                        difficultyRepository.save(difficulty);
                    });
        }
    }

    @Override
    public DifficultyEntity getDifficultyByName(String name) {
        return difficultyRepository.findByDifficulty(DifficultyEnums.valueOf(name));
    }
}
