package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.Comment;
import com.eldarian.dealerstat.model.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CommentController extends AbstractController<Comment, CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }

    @GetMapping("/{authorId}/written-comments")
    public ResponseEntity<List<Comment>> getCommentsByAuthor(@PathVariable Long authorId) {
        List<Comment> commentList = getService().findByAuthorId(authorId);
        return generateListResponse(commentList);
    }

    @GetMapping("{userId}/received-comments/")
    public ResponseEntity<List<Comment>> getCommentsByGameObjectOwnerId(@PathVariable Long userId) {
        List<Comment> commentList = getService().findByTraderId(userId);
        return generateListResponse(commentList);
    }

    @PostMapping("objects/{objectId}/comments")
    public ResponseEntity<Comment> postWithGameObject(@RequestBody Comment comment, @PathVariable Long objectId) {
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        getService().saveWithGameObjectId(comment, objectId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
