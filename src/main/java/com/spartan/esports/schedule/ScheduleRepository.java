package com.spartan.esports.schedule;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
