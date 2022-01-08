package io.github.osmanfurkan115.customer.api;

import io.github.osmanfurkan115.customer.model.Coupon;
import io.github.osmanfurkan115.customer.service.CouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getCoupons() {
        return ResponseEntity.ok(couponService.getCoupons());
    }

    @PostMapping
    public ResponseEntity<Coupon> saveCoupon(@RequestBody @Valid Coupon coupon) {
        return ResponseEntity.ok(couponService.saveCoupon(coupon));
    }
}
