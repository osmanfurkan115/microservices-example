package io.github.osmanfurkan115.customer.repository;

import io.github.osmanfurkan115.customer.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}