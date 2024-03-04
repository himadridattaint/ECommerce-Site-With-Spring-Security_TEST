package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.controller;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Seller;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/all-seller")
    public ResponseEntity<List<Seller>> getAllSeller() {
        List<Seller> sellers = sellerService.getAllSeller();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerNewSeller(@RequestBody Seller seller) {
        sellerService.saveNewSeller(seller);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}