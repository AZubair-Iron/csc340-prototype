package com.csc340.api_demo.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        return service.getCommentById(commentId);
    }

    @PostMapping("/new")
    public List<Comment> addNewComment(@RequestBody Comment comment) {
        service.addNewComment(comment);
        return service.getAllComments();
    }

    @PutMapping("/update/{commentId}")
    public Comment updateComment(@PathVariable int commentId, @RequestBody Comment comment) {
        service.updateComment(commentId, comment);
        return service.getCommentById(commentId);
    }

    @DeleteMapping("/delete/{commentId}")
    public List<Comment> deleteComment(@PathVariable int commentId) {
        service.deleteCommentsById(commentId);
        return service.getAllComments();
    }
}
