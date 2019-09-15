package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.Comment;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface CommentRepository extends CrudRepository {
    Comment findCommentById(int commentId);
    void saveComment(Comment Comment);
    void deleteComment(Comment Comment);
    List<Comment> findCommentByAuthor(int userId);
    List<Comment> findCommentByArticle(int gameObjectId);
}
