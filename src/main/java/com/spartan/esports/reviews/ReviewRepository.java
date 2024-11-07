package com.spartan.esports.reviews;

import com.spartan.esports.coaches.Coach;
import com.spartan.esports.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {


    List<Review> findByNameContainingIgnoreCase(String name);

    List<Review> findByRating(double rating);

    List<Review> findByCommentContainingIgnoreCase(String comment);
}
