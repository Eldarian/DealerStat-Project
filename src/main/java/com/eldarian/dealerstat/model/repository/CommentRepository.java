package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CommonRepository<Comment> {
    List<Comment> findAllByAuthor_Id(Long Id);
    List<Comment> findAllByGameObject_Id(Long Id);
}
