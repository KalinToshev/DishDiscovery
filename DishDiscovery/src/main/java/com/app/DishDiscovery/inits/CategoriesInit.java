package com.app.DishDiscovery.inits;

import com.app.DishDiscovery.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoriesInit implements CommandLineRunner {
    private final CategoryService categoryService;

    @Autowired
    public CategoriesInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
