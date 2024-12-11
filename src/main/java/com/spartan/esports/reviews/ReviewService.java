package com.spartan.esports.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public List<Review> getReviewByRating(double rating) {
        return reviewRepository.findByRating(rating);
    }

    public List<Review> getReviewByComment(String comment) {
        return reviewRepository.findByCommentContainingIgnoreCase(comment);
    }

    public List<Review> getReviewByCoachId(int coachId) {
        return reviewRepository.findByCoachID_CoachId(coachId);
    }

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(int reviewId, Review review) {
        Review existing = getReviewById(reviewId);
        existing.setName(review.getUserId());
        existing.setRating(review.getRating());
        existing.setComment(review.getComment());

        reviewRepository.save(existing);
    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}



