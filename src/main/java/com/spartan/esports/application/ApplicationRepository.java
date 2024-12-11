package com.spartan.esports.application;


import com.spartan.esports.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> getApplicationByGame(Game game);

    List<Application> getApplicationByCoach(String coach);
}
