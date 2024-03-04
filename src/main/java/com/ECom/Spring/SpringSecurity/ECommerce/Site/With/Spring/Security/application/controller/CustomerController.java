package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.controller;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Customer;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @GetMapping("/all-customer")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomer();
    }
    @PostMapping("/register")
    public void saveNewCustomer(@RequestBody Customer customer)
    {
        customerService.saveNewCustomer(customer);
    }
}
