package com.spartan.esports.schedule;

import com.spartan.esports.teamMembers.Member;
import com.spartan.esports.user.User;
import com.spartan.esports.user.UserRepository;
import com.spartan.esports.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserService UserService;

    /**
     * Fetch all Schedules.
     *
     * @return the list of all Schedules.
     */
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    /**
     * Fetch a unique Schedule.
     *
     * @param scheduleId the unique Schedule id.
     * @return a unique Schedule object.
     */
    public Schedule getScheduleById(int scheduleId) {
        return scheduleRepository.findById(scheduleId).orElse(null);
    }


    /**
     * Add a new Schedule to the database.
     *
     * @param schedule the new Schedule to add.
     */
    public void addNewSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    /**
     * Update an existing Schedule.
     *
     * @param scheduleId the unique Schedule Id.
     * @param schedule   the new Schedule details.
     */
    public void updateSchedule(int scheduleId, Schedule schedule) {
        Schedule existing = getScheduleById(scheduleId);
        existing.setScheduleId(schedule.getScheduleId());
        existing.setCoachId(schedule.getCoachId());
        existing.setUserId(schedule.getUserId());
        existing.setStartTime(schedule.getStartTime());
        existing.setEndTime(schedule.getEndTime());
        existing.setDate(schedule.getDate());
        scheduleRepository.save(existing);
    }

    public void updateUserSchedule(int scheduleId, int userId) {
        Schedule existing = getScheduleById(scheduleId);

        User user = UserService.getUserById(userId);

        existing.setUserId(user);

        scheduleRepository.save(existing);
    }


    /**
     * Delete a unique Schedule.
     *
     * @param scheduleId the unique Schedule Id.
     */
    public void deleteScheduleById(int scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
