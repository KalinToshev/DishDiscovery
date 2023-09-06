package com.app.DishDiscovery.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRole(RoleEntity role) {
        this.roles.add(role);
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<RecipeEntity> recipes = new LinkedHashSet<>();

    public void addRecipe(RecipeEntity recipe) {
        recipes.add(recipe);
        recipe.setAuthor(this);
    }

    public void removeRecipe(RecipeEntity recipe) {
        recipes.remove(recipe);
        recipe.setAuthor(null);
    }
}