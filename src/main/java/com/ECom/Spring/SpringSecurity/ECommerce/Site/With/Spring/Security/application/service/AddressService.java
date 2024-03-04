package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Address;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Customer;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Seller;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.AddressRepository;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.CustomerRepository;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SellerRepository sellerRepository;
    public List<Address> getAllAddresses()
    {
        return addressRepository.findAll();
    }
    public void saveNewAddressByCustomer(Address address,Long id) {
        try {
            Customer c = customerRepository.findById(id).orElse(null);
            Address a = new Address();
            a.setStreet(address.getStreet());
            a.setState(address.getState());
            a.setPincode(address.getPincode());
            a.setCountry(address.getCountry());

            a.getCustomers().add(c);
            addressRepository.save(a);
            c.getAddresses().add(a);
            customerRepository.save(c);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void saveNewAddressBySeller(Address address,Long id) {
        try {
            Seller s = sellerRepository.findById(id).orElse(null);
            Address a = new Address();
            a.setStreet(address.getStreet());
            a.setState(address.getState());
            a.setPincode(address.getPincode());
            a.setCountry(address.getCountry());

            a.getSellers().add(s);
            addressRepository.save(a);
            s.getAddresses().add(a);
            sellerRepository.save(s);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
