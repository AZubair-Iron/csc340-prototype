package com.spartan.esports.games;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;

    private String game;
    private String gameIcon;

    private String steamAppId;

    public Game(int gameId, String gameName, String gameIcon, String steamAppId) {
        this.gameId = gameId;
        this.game = gameName;
        this.gameIcon = gameIcon;
        this.steamAppId = steamAppId;
    }

    public Game(String gameName, String gameIcon) {
        this.game = gameName;
        this.gameIcon = gameIcon;
    }

    public Game() {
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameIcon() {
        return this.gameIcon;
    }

    public String getGame() {
        return this.game;
    }

    public void setGameIcon(String gameIcon) {
        this.gameIcon = gameIcon;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSteamAppId() {
        return steamAppId;
    }

    public void setSteamAppId(String steamAppId) {
        this.steamAppId = steamAppId;
    }
}
