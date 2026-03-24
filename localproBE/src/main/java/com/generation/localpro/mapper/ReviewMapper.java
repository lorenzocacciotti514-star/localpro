package com.generation.localpro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.generation.localpro.model.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    
     ReviewDTO toDTO(Review review);
     List<ReviewDTO> toDTOs(List<Review> reviews);

     Review toEntity(ReviewDTO reviewDTO);
     List<Review> toEntities(List<ReviewDTO> reviewsDTO);

}
