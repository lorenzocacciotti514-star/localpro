package com.generation.localpro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.localpro.exception.ResourceNotFoundException;
import com.generation.localpro.model.Review;
import com.generation.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public List<Review> findByUserId(Integer userId) {
        return reviewRepository.findByUserId(userId);
    }

    public Review findById(Integer id) {
        return reviewRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Review update(Integer id, Review review) {
        Review existing = findById(id);
        existing.setUserId(review.getUserId());
        existing.setRating(review.getRating());
        existing.setDescription(review.getDescription());
        return reviewRepository.save(existing);
    }

    public void deleteById(Integer id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }
}
