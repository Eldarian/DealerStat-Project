package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.Comment;

import java.util.List;

public interface CommentService extends CommonService<Comment> {
    List<Comment> findByAuthorId(Long id);
    void saveWithGameObjectId(Comment comment, Long authorId);
    List<Comment> findByTraderId(Long id);
    List<Comment> findByGameObjectId(Long id);
}
