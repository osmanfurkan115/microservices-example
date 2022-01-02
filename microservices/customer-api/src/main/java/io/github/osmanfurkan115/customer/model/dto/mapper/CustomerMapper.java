package io.github.osmanfurkan115.customer.model.dto.mapper;

import io.github.osmanfurkan115.customer.model.Customer;
import io.github.osmanfurkan115.customer.model.dto.CustomerDto;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {
    public CustomerDto customerToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getUserName(),
                customer.getName(), customer.getGender(),
                customer.getEmail(), customer.getPassword(),
                customer.getPhoneNumber());
    }
}