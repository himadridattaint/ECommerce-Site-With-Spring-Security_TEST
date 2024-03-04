package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
    List<Customer> findByMail(String mail);
}
