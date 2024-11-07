package com.csc340.api_demo.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<Comment> getCommentsByMessage(Message message) {
        return commentRepository.getCommentsByMessage(message);
    }

    public void updateComment(int commentId, Comment comment) {
        Comment existing = getCommentById(commentId);
        existing.setMessage(comment.getMessage());
        existing.setContent(comment.getContent());
        existing.setTimePosted(comment.getTimePosted());

        commentRepository.save(existing);
    }

    public void deleteCommentsById(int commentId) {
        commentRepository.deleteById(commentId);
    }

    public void addNewComment(Comment comment) {
        commentRepository.save(comment);
    }
}
