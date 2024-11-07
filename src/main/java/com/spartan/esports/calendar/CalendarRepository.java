package com.spartan.esports.calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {

    @Query(value = "select * from calendar where name like %?%", nativeQuery = true)
    List<Calendar> getCalendarByName(String name);

}
