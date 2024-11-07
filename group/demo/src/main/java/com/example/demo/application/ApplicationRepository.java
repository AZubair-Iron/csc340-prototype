package com.example.demo.application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> getApplicationByGame(String game);

    @Query(value = "select * from application where coach like %?%", nativeQuery = true)
    List<Application> getApplicationByCoach(String coach);
}
