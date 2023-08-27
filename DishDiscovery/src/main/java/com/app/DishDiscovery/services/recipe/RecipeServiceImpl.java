package com.app.DishDiscovery.services.recipe;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import com.app.DishDiscovery.models.dtos.RecipeCardDTO;
import com.app.DishDiscovery.models.entities.RecipeEntity;
import com.app.DishDiscovery.repositories.RecipeRepository;
import com.app.DishDiscovery.services.category.CategoryService;
import com.app.DishDiscovery.services.difficulty.DifficultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    private final DifficultyService difficultyService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ModelMapper modelMapper, CategoryService categoryService, DifficultyService difficultyService) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.difficultyService = difficultyService;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeDTO) {
        RecipeEntity recipeEntity = new RecipeEntity();

        modelMapper.map(addRecipeDTO, recipeEntity);

        recipeEntity.setCategory(categoryService.getCategoryByName(addRecipeDTO.getCategory()));

        recipeEntity.setDifficulty(difficultyService.getDifficultyByName(addRecipeDTO.getDifficulty()));

        recipeRepository.save(recipeEntity);
    }

    @Override
    public List<RecipeCardDTO> getAllRecipes() {
        List<RecipeCardDTO> recipeCardDTOS = new ArrayList<>();

        List<RecipeEntity> allRecipes = recipeRepository.findAll();

        allRecipes.forEach(recipe -> {
            RecipeCardDTO recipeCardDTO = new RecipeCardDTO();

            modelMapper.map(recipe, recipeCardDTO);

            //Make description one sentence
            String description = recipeCardDTO.getDescription();
            description = description.substring(0, description.indexOf(".") + 1);
            recipeCardDTO.setDescription(description);

            recipeCardDTOS.add(recipeCardDTO);
        });

        return recipeCardDTOS;
    }
}
