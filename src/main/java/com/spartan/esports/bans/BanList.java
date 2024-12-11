package com.spartan.esports.bans;

import jakarta.persistence.*;

@Entity
@Table(name = "banned_list")
public class BanList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String offense;

    @Column(nullable = false)
    private String status;


    public BanList(int user_id, String user_name, String offense, String status){
        this.user_id = user_id;
        this.user_name = user_name;
        this.offense = offense;
        this.status = status;
    }

    public BanList(){}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}