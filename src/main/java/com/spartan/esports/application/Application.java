package com.spartan.esports.application;


import com.spartan.esports.games.Game;
import jakarta.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String coach;

    @Column(nullable = false)
    private String rank;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String aplication;

    public Application(int user_id, String coach, String rank, Game game,
                        int year, String aplication) {
        this.user_id = user_id;
        this.coach = coach;
        this.rank = rank;
        this.game = game;
        this.year = year;
        this.aplication = aplication;
    }

    public Application(String coach, String rank, Game game, int year, String aplication) {
        this.coach = coach;
        this.rank = rank;
        this.game = game;
        this.year = year;
        this.aplication = aplication;
    }

    public Application(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAplication() {
        return aplication;
    }

    public void setAplication(String aplication) {
        this.aplication = aplication;
    }
}
