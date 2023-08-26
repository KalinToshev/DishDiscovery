package com.app.DishDiscovery.repositories;

import com.app.DishDiscovery.models.entities.CategoryEntity;
import com.app.DishDiscovery.models.enums.CategoryEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategory(CategoryEnums category);
}