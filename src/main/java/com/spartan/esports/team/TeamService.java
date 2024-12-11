package com.spartan.esports.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(int teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

    public List<Team> getTeamByName(String name) {
        return teamRepository.findByNameContainingIgnoreCase(name);
    }

    public void addNewTeam(Team team) {
        teamRepository.save(team);
    }

    public void updateTeam(int teamId, Team team) {
        Team existing = getTeamById(teamId);
        existing.setName(team.getName());
        existing.setGame(team.getGame());
        existing.setScoreline(team.getScoreline());
        existing.setMatchDay(team.getMatchDay());

        teamRepository.save(existing);
    }

    public void deleteTeamById(int teamId) {
        teamRepository.deleteById(teamId);
    }

}
