package io.github.osmanfurkan115.customer.repository;

import io.github.osmanfurkan115.customer.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}