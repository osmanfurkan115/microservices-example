package io.github.osmanfurkan115.product.api;

import io.github.osmanfurkan115.product.model.dto.ReviewDto;
import io.github.osmanfurkan115.product.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviews() {
        return ResponseEntity.ok(reviewService.getReviews());
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<ReviewDto>> getInactiveReviews() {
        return ResponseEntity.ok(reviewService.getInactiveReviews());
    }

    @PutMapping("/verify/{id}")
    public ResponseEntity<ReviewDto> verifyReview(@PathVariable int id) {
        return ResponseEntity.ok(reviewService.verifyReview(id));
    }
}
