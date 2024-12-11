package com.spartan.esports.teamMembers;

import com.spartan.esports.team.Team;
import com.spartan.esports.user.User;
import jakarta.persistence.*;


@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String tag;

    private String role;

    public Member(int memberId, Team team, User user, String tag, String role) {
        this.memberId = memberId;
        this.team = team;
        this.tag = tag;
        this.user = user;
        this.role = role;
    }

    public Member(Team team, User user, String tag, String role) {
        this.team = team;
        this.user = user;
        this.tag = tag;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


}
