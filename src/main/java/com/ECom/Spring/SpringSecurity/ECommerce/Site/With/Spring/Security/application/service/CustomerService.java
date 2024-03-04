package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Customer;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.AddressRepository;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public ResponseEntity<String> saveNewCustomer(Customer customer) {
        try {
            String hashPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getCustomerId() > 0) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + ex.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Unable to register user");
    }
}
