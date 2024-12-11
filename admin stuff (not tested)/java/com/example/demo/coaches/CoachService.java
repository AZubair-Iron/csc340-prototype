package com.example.demo.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Coach getCoachById(int CoachId) {
        return coachRepository.findById(CoachId).orElse(null);
    }

    public List<Coach> getCoachByGame(String game) {
        return coachRepository.findByGameContainingIgnoreCase(game);
    }

    public List<Coach> getCoachByName(String name) {
        return coachRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Coach> getCoachByRank(String rank) {
        return coachRepository.findByRank(rank);
    }

    public void addNewCoach(Coach Coach) {
        coachRepository.save(Coach);
    }

    public void updateCoach(int CoachId, Coach Coach) {
        Coach existing = getCoachById(CoachId);
        existing.setName(Coach.getName());
        existing.setGame(Coach.getGame());

        coachRepository.save(existing);
    }

    public void saveCoach(Coach coach) {
        coachRepository.save(coach);
    }

    public void deleteCoachById(int CoachId) {
        coachRepository.deleteById(CoachId);
    }
}
