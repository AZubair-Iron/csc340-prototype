package com.spartan.esports.team;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByGame(String game);

    List<Team> findByName(String name);

    List<Team> findByNameContainingIgnoreCase(String name);

    List<Team> findByGameContainingIgnoreCase(String game);
}
