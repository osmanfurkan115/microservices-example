package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Review;
import io.github.osmanfurkan115.product.model.dto.ReviewDto;
import io.github.osmanfurkan115.product.model.dto.mapper.ReviewMapper;
import io.github.osmanfurkan115.product.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDto> getReviews() {
        return reviewRepository.findAll().stream().map(reviewMapper::reviewToReviewDto).collect(Collectors.toList());
    }

    public List<ReviewDto> getInactiveReviews() {
        return reviewRepository.findByActiveFalse().orElseThrow(EntityNotFoundException::new)
                .stream().map(reviewMapper::reviewToReviewDto).collect(Collectors.toList());
    }

    public ReviewDto verifyReview(int reviewId) {
        final Review review = reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        review.setActive(true);
        return reviewMapper.reviewToReviewDto(reviewRepository.save(review));
    }
}
