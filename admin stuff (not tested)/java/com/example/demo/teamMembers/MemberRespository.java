package com.example.demo.teamMembers;


import com.example.demo.teams.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface MemberRespository extends JpaRepository<Member, Integer>{

    List<Member> findByRole(String role);

    List<Member> findByTeam(Team teamId);
}