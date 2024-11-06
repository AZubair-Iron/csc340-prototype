package com.csc340.api_demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for Customer.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getCustomersByMajor(String major);

    List<Customer> findByAccountStatus(String accountStatus);

    @Query(value = "SELECT * FROM customers c WHERE size(c.events) > ?1", nativeQuery = true)
    List<Customer> findCustomersWithMoreThanXEvents(int eventCount);
}
