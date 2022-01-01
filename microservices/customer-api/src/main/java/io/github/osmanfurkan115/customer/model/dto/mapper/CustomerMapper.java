package io.github.osmanfurkan115.customer.model.dto.mapper;

import io.github.osmanfurkan115.customer.model.Customer;
import io.github.osmanfurkan115.customer.model.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {
    public CustomerDto customerToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getUserName(),
                customer.getName(), customer.getEmail(),
                customer.getPhoneNumber());
    }

    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getUserName(),
                customerDto.getName(), customerDto.getEmail(),
                customerDto.getPhoneNumber(), LocalDateTime.now());
    }
}
