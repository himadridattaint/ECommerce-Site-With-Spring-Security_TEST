package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long>
{
    List<Seller> findByMail(String mail);
}
