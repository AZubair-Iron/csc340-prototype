package com.spartan.esports.schedule;

import com.spartan.esports.coaches.Coach;
import com.spartan.esports.user.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scheduleId;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coachId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;


    @Column(nullable = false)
    private LocalDate date;



    public Schedule(int scheduleId, Coach coachId, User userId, LocalTime startTime, LocalTime endTime, LocalDate date) {
        this.scheduleId = scheduleId;
        this.coachId = coachId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public Schedule(Coach coachId, User userId, LocalTime startTime, LocalTime endTime, LocalDate date) {
        this.coachId = coachId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    public Schedule() {
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setCoachId(Coach coachId) {
        this.coachId = coachId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public Coach getCoachId() {
        return coachId;
    }

    public User getUserId() {
        return userId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getDate() {
        return date;
    }


}
