package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="ADDRESS")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String state;
    private String country;
    private String pincode;
    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> customers = new HashSet<>();
    @ManyToMany(mappedBy = "addresses")
    private Set<Seller> sellers = new HashSet<>();

}
