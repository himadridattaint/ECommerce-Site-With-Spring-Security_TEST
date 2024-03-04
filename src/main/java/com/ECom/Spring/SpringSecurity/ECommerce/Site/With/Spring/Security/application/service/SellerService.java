package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Seller;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SellerService(SellerRepository sellerRepository, PasswordEncoder passwordEncoder) {
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    public void saveNewSeller(Seller seller) {
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        sellerRepository.save(seller);
    }
}

