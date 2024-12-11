package com.spartan.esports.team;

import com.spartan.esports.games.Game;
import jakarta.persistence.*;


@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private String scoreline;
    private String matchDay;

    public Team(int teamId, String name, Game game, String scoreline, String matchDay) {
        this.teamId = teamId;
        this.name = name;
        this.game = game;
        this.scoreline = scoreline;
        this.matchDay = matchDay;
    }

    public Team(String name, Game game, String scoreline, String matchDay) {
        this.name = name;
        this.game = game;
        this.scoreline = scoreline;
        this.matchDay = matchDay;

    }

    public Team() {
    }

    public int getTeamId() {
        return this.teamId;
    }


    public String getName() { return this.name; }

    public Game getGame() { return this.game; }

    public void setName(String name) { this.name = name; }

    public void setGame(Game game) { this.game = game; }


    public String getMatchDay() {
        return matchDay;
    }

    public String getScoreline() {
        return scoreline;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    public void setScoreline(String scoreline) {
        this.scoreline = scoreline;
    }
}
