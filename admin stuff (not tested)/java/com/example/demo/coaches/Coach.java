package com.example.demo.coaches;

import jakarta.persistence.*;


@Entity
@Table(name = "coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coachId;
    private String name;
    private String rank;
    private double rating;
    private String game;

    public Coach(int coachId, String name, String rank, double rating, String game) {
        this.coachId = coachId;
        this.name = name;
        this.rank = rank;
        this.rating = rating;
        this.game  = game;
    }

    public Coach(String name, String rank, double rating, String game) {
        this.name = name;
        this.rank = rank;
        this.rating = rating;
        this.game = game;
    }

    public Coach() {
    }


    public int getCoachId() {
        return coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGame(String game) {
        this.game = game;
    }
}