package com.spartan.esports.coaches;

import com.spartan.esports.games.Game;
import com.spartan.esports.games.GameRepository;
import com.spartan.esports.reviews.Review;
import com.spartan.esports.reviews.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Coach getCoachById(int CoachId) {
        return coachRepository.findById(CoachId).orElse(null);
    }

    public List<Coach> getCoachByGame(String game) {
        return coachRepository.findByGameContainingIgnoreCase(game);
    }


    public List<Coach> getCoachByRank(String rank) {
        return coachRepository.findByRank(rank);
    }

    public void addNewCoach(Coach Coach) {
        coachRepository.save(Coach);
    }

    public void updateCoach(int CoachId, String game, String rank, String content) {
        Coach existing = getCoachById(CoachId);
        existing.setGame(game);
        existing.setRank(rank);
        existing.setContent(content);

        coachRepository.save(existing);
    }

    public void deleteCoachById(int CoachId) {
        coachRepository.deleteById(CoachId);
    }

    public double getAverageRatingForCoach(int coachId) {
        List<Review> reviews = reviewRepository.findByCoachID_CoachId(coachId);

        if (reviews.isEmpty()) {
            return 5.0;
        }

        return reviews.stream().mapToDouble(Review::getRating).average().orElse(5.0);

    }
}
