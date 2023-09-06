package com.app.DishDiscovery.services.recipe;

import com.app.DishDiscovery.models.dtos.AddRecipeDTO;
import com.app.DishDiscovery.models.dtos.RecipeCardDTO;
import com.app.DishDiscovery.models.dtos.RecipeDTO;
import com.app.DishDiscovery.models.dtos.ShowCurrentUserRecipeCardDTO;
import com.app.DishDiscovery.models.entities.RecipeEntity;
import com.app.DishDiscovery.models.entities.UserEntity;
import com.app.DishDiscovery.repositories.RecipeRepository;
import com.app.DishDiscovery.services.category.CategoryService;
import com.app.DishDiscovery.services.difficulty.DifficultyService;
import com.app.DishDiscovery.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    private final DifficultyService difficultyService;

    private final UserService userService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ModelMapper modelMapper, CategoryService categoryService, DifficultyService difficultyService, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.difficultyService = difficultyService;
        this.userService = userService;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeDTO) {
        RecipeEntity recipeEntity = new RecipeEntity();

        modelMapper.map(addRecipeDTO, recipeEntity);

        recipeEntity.setCategory(categoryService.getCategoryByName(addRecipeDTO.getCategory()));

        recipeEntity.setDifficulty(difficultyService.getDifficultyByName(addRecipeDTO.getDifficulty()));

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserEntity user = userService.getUserEntityByUsername(userDetails.getUsername());

        user.addRecipe(recipeEntity);

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

    @Override
    public List<ShowCurrentUserRecipeCardDTO> getAllPersonalRecipes() {
        List<ShowCurrentUserRecipeCardDTO> showCurrentUserRecipeCardDTOS = new ArrayList<>();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity userEntityByUsername = userService.getUserEntityByUsername(username);

        Long id = userEntityByUsername.getId();

        List<RecipeEntity> byAuthorId = recipeRepository.findByAuthor_Id(id);

        byAuthorId.forEach(recipe -> {
            ShowCurrentUserRecipeCardDTO showCurrentUserRecipeCardDTO = new ShowCurrentUserRecipeCardDTO();

            modelMapper.map(recipe, showCurrentUserRecipeCardDTO);

            showCurrentUserRecipeCardDTOS.add(showCurrentUserRecipeCardDTO);
        });

        return showCurrentUserRecipeCardDTOS;
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public RecipeEntity getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no recipe with this ID!"));
    }

    @Override
    public RecipeDTO convertToDTO(RecipeEntity recipeEntity) {
        RecipeDTO recipeDTO = new RecipeDTO();

        modelMapper.map(recipeEntity, recipeDTO);

        if (recipeEntity.getAuthor() != null) {recipeDTO.setAuthorName(recipeEntity.getAuthor().getFullName());}

        return recipeDTO;
    }
}
