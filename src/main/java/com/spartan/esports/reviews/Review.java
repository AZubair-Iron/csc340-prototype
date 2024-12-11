package com.spartan.esports.reviews;

import com.spartan.esports.coaches.Coach;
import com.spartan.esports.user.User;
import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;


    private double rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coachID;

    public Review(int commentId, User name, double rating, String comment, Coach coachID) {
        this.commentId = commentId;
        this.userId = name;
        this.rating = rating;
        this.comment = comment;
        this.coachID = coachID;

    }

    public Review( User name, double rating, String comment) {
        this.userId = name;
        this.rating = rating;
        this.comment = comment;

    }

    public Review() {

    }

    public int getCommentId() {
        return commentId;
    }


    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setName(User name) {
        this.userId = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Coach getCoachID() {
        return coachID;
    }

    public User getUserId() {
        return userId;
    }

    public void setCoachID(Coach coachID) {
        this.coachID = coachID;
    }
}
