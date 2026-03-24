package com.generation.localpro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.localpro.model.PortalUser;
import com.generation.localpro.model.Review;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReviewService 
{
    @Autowired
    private ReviewRepository reviewRepository;
 
    @Autowired
    private PortalUserService portalUserService;



    public List<PortalUser> findAll() {
        return portalUserRepository.findAll();
    }

    public ReviewDTO findById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + id));
        return reviewMapper.toDTO(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    public ReviewDTO save(@Valid ReviewDTO reviewDTO) {
        Review review = reviewMapper.toEntity(reviewDTO);
        review = reviewRepository.save(review);
        return reviewMapper.toDTO(review);
    }
    
}
