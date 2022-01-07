package io.github.osmanfurkan115.customer.api;

import io.github.osmanfurkan115.customer.model.Address;
import io.github.osmanfurkan115.customer.model.dto.CreateAddressRequest;
import io.github.osmanfurkan115.customer.model.dto.UpdateAddressRequest;
import io.github.osmanfurkan115.customer.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }


    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody @Valid CreateAddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.saveAddress(addressRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable int id, @RequestBody UpdateAddressRequest addressRequest) {
        return ResponseEntity.ok(addressService.updateAddress(id, addressRequest));
    }
}
