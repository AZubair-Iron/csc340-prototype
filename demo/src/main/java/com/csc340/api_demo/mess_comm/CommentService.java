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

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(Comment comment) {
        // Ensure that the associated message exists
        Message message = messageRepository.findById(comment.getMessage().getMessId()).orElse(null);
        if (message != null) {
            comment.setMessage(message);
            comment.setTimePosted(LocalDateTime.now());  // Now works since timePosted is added to Comment
            return commentRepository.save(comment);
        }
        return null;  // Return null if the message doesn't exist
    }

    public Comment updateComment(Long commentId, Comment comment) {
        Comment existingComment = commentRepository.findById(commentId).orElse(null);
        if (existingComment != null) {
            existingComment.setContent(comment.getContent());
            existingComment.setAuthorId(comment.getAuthorId());
            return commentRepository.save(existingComment);
        }
        return null;  // Return null if comment does not exist
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
