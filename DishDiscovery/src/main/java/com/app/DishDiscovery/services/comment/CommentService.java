package com.app.DishDiscovery.services.comment;

import com.app.DishDiscovery.models.entities.CommentEntity;

import java.util.List;

public interface CommentService {
    void addComment(CommentEntity comment);

    List<CommentEntity> getAllCommentsByRecipeId(Long id);
}
