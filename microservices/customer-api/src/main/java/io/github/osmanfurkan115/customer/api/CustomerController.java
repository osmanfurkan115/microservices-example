package io.github.osmanfurkan115.customer.api;

import io.github.osmanfurkan115.customer.model.dto.CustomerDto;
import io.github.osmanfurkan115.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDto>> getCustomers(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(customerService.getAll(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveProduct(@RequestBody @Valid CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.saveProduct(customerDto));
    }
}
