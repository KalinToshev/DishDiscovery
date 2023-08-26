package com.app.DishDiscovery.services.category;

import com.app.DishDiscovery.models.entities.CategoryEntity;

public interface CategoryService {
    void initCategories();

    CategoryEntity getCategoryByName(String name);
}
