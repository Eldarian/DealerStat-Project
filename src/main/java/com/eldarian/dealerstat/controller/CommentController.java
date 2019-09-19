package com.eldarian.dealerstat.controller;

import com.eldarian.dealerstat.model.entities.Comment;
import com.eldarian.dealerstat.model.service.CommentService;
import com.eldarian.dealerstat.model.service.CommonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController extends AbstractController<Comment, CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }

    @PostMapping("/{id}/comments")
    public void postComment() {

    }

    @GetMapping("/{id}/comments")
    public void getComments() {}

    @GetMapping("/{id}/comments/{id}")
    public void getCommentById() {}

    @DeleteMapping("/{id}/comments/{id}")
    public void deleteComment() {}

    @PutMapping("/{id}/comments")
    public void updateComment() {}
}
