package com.spartan.esports.report;

import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String offense;

    @Column(nullable = false)
    private int recount;

    public Report(int id, String name, String offense, int recount) {
        this.id = id;
        this.name = name;
        this.offense = offense;
        this.recount = recount;
    }

    public Report(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public int getRecount() {
        return recount;
    }

    public void setRecount(int recount) {
        this.recount = recount;
    }
}
