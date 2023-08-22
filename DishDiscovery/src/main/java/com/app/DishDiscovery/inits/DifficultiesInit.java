package com.app.DishDiscovery.inits;

import com.app.DishDiscovery.services.difficulty.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DifficultiesInit implements CommandLineRunner {
    private final DifficultyService difficultyService;

    @Autowired
    public DifficultiesInit(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @Override
    public void run(String... args) throws Exception {
        difficultyService.initDifficulties();
    }
}
