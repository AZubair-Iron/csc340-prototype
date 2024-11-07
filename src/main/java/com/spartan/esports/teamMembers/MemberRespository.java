package com.spartan.esports.teamMembers;

import com.spartan.esports.team.Team;
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

    List<Member> findByTeam(Team team);
}
