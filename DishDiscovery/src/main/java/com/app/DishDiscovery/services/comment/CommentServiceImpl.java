package com.app.DishDiscovery.services.comment;

import com.app.DishDiscovery.models.entities.CommentEntity;
import com.app.DishDiscovery.repositories.CommentRepository;
import com.app.DishDiscovery.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<CommentEntity> getAllCommentsByRecipeId(Long id) {
        return commentRepository.findByRecipe_Id(id);
    }
}
