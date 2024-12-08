package com.spartan.esports.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@Entity
@Table(name = "users")
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int userId;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus accountStatus;

    @Column(nullable = false)
    private String major;

    @ElementCollection
    @CollectionTable(name = "user_events", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "event_id")
    private List<String> events = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_games", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "game_id")
    private List<String> games = new ArrayList<>();

    /* Constructor */
    public User() {
    }

    public User(String name, String email, String password, AccountStatus accountStatus, String major) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.major = major;
    }

    /* Getter and Setter */

    public int getUserId() {  // userId
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {  // name
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {  // email
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {  // password
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getAccountStatus() {  // account status
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getMajor() {  // major
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<String> getEvents() {  // events
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<String> getGames() {  // games
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  User)) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name=" + name + '\'' +
                ", email=" + email + '\'' +
                ", accountStatus=" + accountStatus + '\'' +
                ", major=" + major + '\'' +
                ", events=" + events + '\'' +
                ", games=" + games +
                '}';
    }
}