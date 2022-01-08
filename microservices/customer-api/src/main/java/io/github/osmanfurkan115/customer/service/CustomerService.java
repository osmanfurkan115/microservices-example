package io.github.osmanfurkan115.customer.service;

import io.github.osmanfurkan115.customer.model.Coupon;
import io.github.osmanfurkan115.customer.model.Customer;
import io.github.osmanfurkan115.customer.model.dto.CustomerDto;
import io.github.osmanfurkan115.customer.model.dto.mapper.CustomerMapper;
import io.github.osmanfurkan115.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CouponService couponService;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, CouponService couponService) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.couponService = couponService;
    }

    public Page<CustomerDto> getAll(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size, Sort.by("userName").ascending());
        return customerRepository.findAll(pageable).map(customerMapper::customerToCustomerDto);
    }

    public CustomerDto getCustomerById(Long id) {
        return customerMapper.customerToCustomerDto(findCustomerById(id));
    }

    protected Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        final Customer customer = new Customer(customerDto.getId(), customerDto.getUserName(),
                customerDto.getName(), customerDto.getGender(),
                customerDto.getEmail(), customerDto.getPassword(),
                customerDto.getPhoneNumber(), customerDto.getAddress(),
                customerDto.getCoupons(), LocalDateTime.now());
        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }

    public CustomerDto addCouponToCustomer(long customerId, int couponId) {
        final Customer customer = findCustomerById(customerId);
        final Coupon coupon = couponService.getCouponById(couponId);
        customer.getCoupons().add(coupon);
        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }
}
