package io.github.osmanfurkan115.product.model.dto.mapper;

import io.github.osmanfurkan115.product.model.Review;
import io.github.osmanfurkan115.product.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewDto reviewToReviewDto(Review review) {
        return new ReviewDto(review.getId(), review.getComment(),
                review.getRate(), review.getCustomerId(),
                review.getProduct(), review.getActive(),
                review.getCreatedDate());
    }
}
