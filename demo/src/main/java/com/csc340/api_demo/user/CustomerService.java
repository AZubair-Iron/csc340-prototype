package com.csc340.api_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID " + customerId));
    }

    // Get customers by major
    public List<Customer> getCustomersByMajor(String major) {
        return customerRepository.findByMajor(major);
    }

    // Add a new customer
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long customerId, Customer customer) {
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Customer not found with ID " + customerId);
        }
        customer.setUserId(customerId);  // Make sure to set the ID of the customer
        return customerRepository.save(customer);
    }

    // Delete a customer by ID
    public void deleteCustomerById(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Customer not found with ID " + customerId);
        }
        customerRepository.deleteById(customerId);
    }
}
