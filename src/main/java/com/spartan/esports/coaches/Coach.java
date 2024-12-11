package com.spartan.esports.coaches;

import com.spartan.esports.schedule.Schedule;
import com.spartan.esports.user.User;
import jakarta.persistence.*;


@Entity
@Table(name = "coaches")
public class Coach {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int coachId;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User userId;

        private String rank;
        private double rating;
        private String game;
        private String content;


    public Coach(int coachId, User name, String rank, double rating, String game, String content) {
        this.coachId = coachId;
        this.userId = name;
        this.rank = rank;
        this.rating = rating;
        this.game  = game;
        this.content = content;
    }

    public Coach(User name, String rank, double rating, String game, String content) {
        this.userId = name;
        this.rank = rank;
        this.rating = rating;
        this.game = game;
        this.content = content;
    }

    public Coach() {
    }


    public int getCoachId() {
        return coachId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public String getRank() {
        return rank;
    }

    public String getGame() {
        return game;
    }

    public String getContent() {
        return content;
    }



    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
