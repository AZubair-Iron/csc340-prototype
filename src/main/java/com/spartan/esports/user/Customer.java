package com.csc340.api_demo.user;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountStatus;

    private String major;

    @ElementCollection
    private List<String> events;

    @ElementCollection
    private List<String> games;

    // Constructors
    public Customer(int userId, String name, String email, String password, String accountStatus, String major, List<String> events, List<String> games) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.major = major;
        this.events = events;
        this.games = games;
    }

    public Customer(String name, String email, String password, String accountStatus, String major, List<String> events, List<String> games) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountStatus = accountStatus;
        this.major = major;
        this.events = events;
        this.games = games;
    }

    public Customer() {
    }

    // Getter and Setter Methods
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    public List<String> getEvents() {
        return events;
    }
    public void setEvents(List<String> events) {
        this.events = events;
    }

    public List<String> getGames() {
        return games;
    }
    public void setGames(List<String> games) {
        this.games = games;
    }
}
