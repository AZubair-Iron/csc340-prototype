package com.spartan.esports.reviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;

    /**
     *
     * http://localhost:8080/reviews/all
     * @return all reviews
     */
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    /**
     * http://localhost:8080/reviews/{reviewId}
     * @param ReviewId
     * @return specific Review
     */

    @GetMapping("/{ReviewId}")
    public Review GetReview(@PathVariable int ReviewId) {
        return service.getReviewById(ReviewId);
    }

    /**
     * http://localhost:8080/reviews/name?name="John"
     * @param name
     * @return a review via name
     */
    @GetMapping("/name")
    public List<Review> getReviewByName(@RequestParam(name = "name", defaultValue = "John") String name) {
        return service.getReviewByName(name);
    }

    /**
     * http://localhost:8080/reviews/comment?comment="PLACEHOLDER"
     * @param name
     * @return reviews via a comment
     */
    @GetMapping("/comment")
    public List<Review> getReviewByComment(@RequestParam(name = "comment", defaultValue = "PLACEHOLDER") String name) {
        return service.getReviewByComment(name);
    }

    /**
     * http://localhost:8080/reviews/rating?rating=5.0
     * @param rating
     * @return reviews via a rating
     */
    @GetMapping("/rating")
    public List<Review> getReviewByRating(@RequestParam(name = "rating", defaultValue = "5.0") double rating) {
        return service.getReviewByRating(rating);
    }

    /**
     * http://localhost:8080/reviews/new
     * @param Review
     * @return a new review
     */

    @PostMapping("/new")
    public List<Review> addNewReview(@RequestBody Review Review){
        service.addNewReview(Review);
        return service.getAllReviews();
    }

    /**
     * http://localhost:8080/reviews/update/{reviewId}
     * @param ReviewId
     * @param Review
     * @return the updated review
     */
    @PutMapping("/update/{ReviewId}")
    public Review updateReview(@PathVariable int ReviewId, @RequestBody Review Review) {
        service.updateReview(ReviewId, Review);
        return service.getReviewById(ReviewId);
    }

    /**
     * http://localhost:8080/reviews/delete/{ReviewId}
     * @param ReviewId
     * @return deleted review
     */
    @DeleteMapping("/delete/{ReviewId}")
    public List<Review> deleteReviewById(@PathVariable int ReviewId) {
        service.deleteReviewById(ReviewId);
        return service.getAllReviews();
    }

}
