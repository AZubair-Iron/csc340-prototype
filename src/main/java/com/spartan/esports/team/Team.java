package com.spartan.esports.team;

import jakarta.persistence.*;


@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teamId;

    private String name;
    private String game;

    public Team(int teamId, String name, String game) {
        this.teamId = teamId;
        this.name = name;
        this.game = game;
    }

    public Team(String name, String game) {
        this.name = name;
        this.game = game;
    }

    public Team() {
    }

    public int getTeamId() {
        return this.teamId;
    }


    public String getName() { return this.name; }

    public String getGame() { return this.game; }

    public void setName(String name) { this.name = name; }

    public void setGame(String game) { this.game = game; }


}
