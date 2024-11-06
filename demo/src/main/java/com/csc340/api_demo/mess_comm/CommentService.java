package com.csc340.api_demo.mess_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByMessageId(Long messId) {
        return commentRepository.findByMessage_MessId(messId);
    }
}
