package io.github.osmanfurkan115.customer.service;

import io.github.osmanfurkan115.customer.model.Address;
import io.github.osmanfurkan115.customer.model.dto.CreateAddressRequest;
import io.github.osmanfurkan115.customer.model.dto.UpdateAddressRequest;
import io.github.osmanfurkan115.customer.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CustomerService customerService;

    public AddressService(AddressRepository addressRepository, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address saveAddress(CreateAddressRequest addressRequest) {
        final Address address = new Address(addressRequest.getId(), addressRequest.getAddress(),
                addressRequest.getAddressName(), customerService.findCustomerById(addressRequest.getCustomerId()));
        return addressRepository.save(address);
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Address updateAddress(int id, UpdateAddressRequest addressRequest) {
        final Address category = getAddressById(id);
        Optional.ofNullable(addressRequest.getAddressName()).ifPresent(category::setAddressName);
        Optional.ofNullable(addressRequest.getAddress()).ifPresent(category::setAddress);
        return addressRepository.save(category);
    }
}
