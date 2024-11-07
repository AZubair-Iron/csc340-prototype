package com.csc340.api_demo.mess_comm;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messId;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    @Column(nullable = false)
    private Long authorId;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(nullable = false)
    private LocalDateTime timePosted;

    public Message(int messId, String title, String description, Long authorId, LocalDateTime timePosted) {
        this.messId = messId;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.timePosted = timePosted;
    }

    public Message(String title, String description, Long authorId, LocalDateTime timePosted) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.timePosted = timePosted;
    }

    public Message() {}

    public int getMessId() { return messId; }
    public void setMessId(int messId) { this.messId = messId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }

    public LocalDateTime getTimePosted() { return timePosted; }
    public void setTimePosted(LocalDateTime timePosted) { this.timePosted = timePosted; }
}
