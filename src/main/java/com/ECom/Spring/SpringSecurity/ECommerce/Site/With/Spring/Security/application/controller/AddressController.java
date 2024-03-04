package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.controller;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Address;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController
{
    @Autowired
    private AddressService addressService;
    @GetMapping("/all-address")
    public List<Address> getAllAddress()
    {
        return addressService.getAllAddresses();
    }
    @PostMapping("/register-address-seller/{seller_id}")
    public void saveNewAddressBySeller(@RequestBody Address address, @PathVariable Long id)
    {
        addressService.saveNewAddressBySeller(address,id);
    }
    @PostMapping("/register-address-customer/{customer_id}")
    public void saveNewAddressByCustomer(@RequestBody Address address, @PathVariable Long id)
    {
        addressService.saveNewAddressByCustomer(address,id);
    }
}
