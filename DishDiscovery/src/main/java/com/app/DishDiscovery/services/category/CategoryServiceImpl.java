package com.app.DishDiscovery.services.category;

import com.app.DishDiscovery.models.entities.CategoryEntity;
import com.app.DishDiscovery.models.enums.CategoryEnums;
import com.app.DishDiscovery.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnums.values())
                    .forEach(category_ -> {
                        CategoryEntity category = new CategoryEntity(category_);
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity getCategoryByName(String name) {
        return categoryRepository.findByCategory(CategoryEnums.valueOf(name));
    }
}
