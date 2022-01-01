package io.github.osmanfurkan115.customer.service;

import io.github.osmanfurkan115.customer.model.dto.CustomerDto;
import io.github.osmanfurkan115.customer.model.dto.mapper.CustomerMapper;
import io.github.osmanfurkan115.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public Page<CustomerDto> getAll(int page, int size) {
        final Pageable pageable = PageRequest.of(page,size, Sort.by("userName").ascending());
        return customerRepository.findAll(pageable).map(customerMapper::customerToCustomerDto);
    }

    public CustomerDto getCustomerById(Long id) {
        return customerMapper.customerToCustomerDto(customerRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public CustomerDto saveCustomer(CustomerDto productDto) {
        return customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(productDto)));
    }
}
