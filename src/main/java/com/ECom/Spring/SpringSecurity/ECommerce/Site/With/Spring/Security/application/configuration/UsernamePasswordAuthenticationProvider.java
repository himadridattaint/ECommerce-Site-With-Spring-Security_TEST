package com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.configuration;

import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Customer;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.model.Seller;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.CustomerRepository;
import com.ECom.Spring.SpringSecurity.ECommerce.Site.With.Spring.Security.application.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsernamePasswordAuthenticationProvider(CustomerRepository customerRepository, SellerRepository sellerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<Customer> customers = customerRepository.findByMail(username);
        if (!customers.isEmpty()) {
            Customer customer = customers.get(0);
            if (passwordEncoder.matches(password, customer.getPassword())) {
                List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("CUSTOMER"));
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new BadCredentialsException("Invalid username or password!");
            }
        }

        List<Seller> sellers = sellerRepository.findByMail(username);
        if (!sellers.isEmpty()) {
            Seller seller = sellers.get(0);
            if (passwordEncoder.matches(password, seller.getPassword())) {
                List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("SELLER"));
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new BadCredentialsException("Invalid username or password!");
            }
        }

        throw new BadCredentialsException("Invalid username or password!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}