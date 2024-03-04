package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="CUSTOMER")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String mail;
    private String password;
    private String role;
    @ManyToMany
    @JoinTable(name="customer_address",joinColumns =
    @JoinColumn(name="customer_id"),inverseJoinColumns =
    @JoinColumn(name="address_id"))
    private Set<Address> addresses = new HashSet<>();
}
