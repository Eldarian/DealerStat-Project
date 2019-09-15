package com.eldarian.dealerstat.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @PostMapping("/articles/{id}/comments")
    public void postComment() {}

    @GetMapping("/articles/{id}/comments")
    public void getComments() {}

    @GetMapping("/articles/{id}/comments/{id}")
    public void getCommentById() {}

    @DeleteMapping("/articles/{id}/comments/{id}")
    public void deleteComment() {}

    @PutMapping("/articles/{id}/comments")
    public void updateComment() {}
}
