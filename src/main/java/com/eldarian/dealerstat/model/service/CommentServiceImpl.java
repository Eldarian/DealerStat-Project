package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.Comment;
import com.eldarian.dealerstat.model.repository.CommentRepository;
import com.eldarian.dealerstat.model.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }
}
