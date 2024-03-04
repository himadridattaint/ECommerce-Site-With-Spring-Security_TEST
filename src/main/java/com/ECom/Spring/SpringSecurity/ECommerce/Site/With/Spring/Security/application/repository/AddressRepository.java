package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
