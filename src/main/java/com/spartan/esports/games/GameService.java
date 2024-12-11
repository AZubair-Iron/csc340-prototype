package com.spartan.esports.games;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(int gameId) {
        return gameRepository.findById(gameId).orElse(null);
    }

    public List<Game> getGameByName(String name) {
        return gameRepository.findByGameContainingIgnoreCase(name);
    }

    public void addNewGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(int gameId, Game game) {
        Game existing = getGameById(gameId);
        existing.setGame(game.getGame());
        existing.setGameIcon(game.getGameIcon());

        gameRepository.save(existing);
    }

    public void deleteGameById(int gameId) {
        gameRepository.deleteById(gameId);
    }






}