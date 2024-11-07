package com.csc340.api_demo.mess_comm;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    @Column(nullable = false)
    private int authorId;

    @ManyToOne
    @JoinColumn(name = "messId", nullable = false)
    private Message message;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime timePosted;  // Add this field

    public Comment() {
    }

    public Comment(int commentId, int authorId, Message message, String content, LocalDateTime timePosted) {
        this.commentId = commentId;
        this.authorId = authorId;
        this.message = message;
        this.content = content;
        this.timePosted = timePosted;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(LocalDateTime timePosted) {
        this.timePosted = timePosted;
    }
}
