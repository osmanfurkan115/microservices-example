package io.github.osmanfurkan115.customer.service;

import io.github.osmanfurkan115.customer.model.Coupon;
import io.github.osmanfurkan115.customer.model.Customer;
import io.github.osmanfurkan115.customer.repository.CouponRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public List<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCouponById(int id) {
        return couponRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
