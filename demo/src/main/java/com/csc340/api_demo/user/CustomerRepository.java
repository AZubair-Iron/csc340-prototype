package com.csc340.api_demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customers by major
    List<Customer> findByMajor(String major);
}
