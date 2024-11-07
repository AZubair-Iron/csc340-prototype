package com.spartan.esports.teamMembers;

import com.spartan.esports.team.Team;
import jakarta.persistence.*;


@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    private String role;

    public Member(int memberId, Team team, String role) {
        this.memberId = memberId;
        this.team = team;
        this.role = role;
    }

    public Member(Team team, String role) {
        this.team = team;
        this.role = role;
    }

    public Member() {

    }

    public int getMemberId() {
        return this.memberId;
    }

    public Team getTeam() {
        return this.team;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


}
