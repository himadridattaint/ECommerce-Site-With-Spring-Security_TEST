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
@Table(name="SELLER")
public class Seller
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;
    private String sellerName;
    private String mail;
    private String password;
    private String role;
    @ManyToMany
    @JoinTable(name="seller_address",joinColumns =
    @JoinColumn(name="seller_id"),inverseJoinColumns =
    @JoinColumn(name="address_id"))
    private Set<Address> addresses = new HashSet<>();
}
