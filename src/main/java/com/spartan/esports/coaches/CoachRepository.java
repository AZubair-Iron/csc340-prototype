package com.spartan.esports.coaches;


import com.spartan.esports.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CoachRepository extends JpaRepository<Coach, Integer> {
    List<Coach> findByGame(String game);

    List<Coach> findByName(String name);

    List<Coach> findByRank(String rank);

    List<Coach> findByNameContainingIgnoreCase(String name);

    List<Coach> findByGameContainingIgnoreCase(String game);
}
