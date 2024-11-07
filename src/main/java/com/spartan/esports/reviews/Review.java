package com.spartan.esports.reviews;

import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    private String name;
    private double rating;
    private String comment;

    public Review(int commentId, String name, double rating, String comment) {
        this.commentId = commentId;
        this.name = name;
        this.rating = rating;
        this.comment = comment;

    }

    public Review( String name, double rating, String comment) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;

    }

    public Review() {

    }

    public int getCommentId() {
        return commentId;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
