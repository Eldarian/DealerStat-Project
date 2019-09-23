package com.eldarian.dealerstat.model.service;

import com.eldarian.dealerstat.model.entities.Comment;
import com.eldarian.dealerstat.model.entities.GameObject;
import com.eldarian.dealerstat.model.repository.CommentRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment, CommentRepository> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Override
    public List<Comment> findByAuthorId(Long id) {
        return repository.findAllByAuthor_Id(id);
    }

    @Override
    public void saveWithGameObjectId(Comment comment, Long id) {
        GameObject gameObject = comment.getGameObject();
        if (gameObject==null) gameObject = new GameObject();
        comment.setGameObject(gameObject);
        repository.save(comment);
    }

    @Override
    public List<Comment> findByTraderId(Long id) {
        return repository.findAllByGameObject_Owner_Id(id);
    }

    @Override
    public List<Comment> findByGameObjectId(Long id) {
        return repository.findAllByGameObject_Id(id);
    }
}
