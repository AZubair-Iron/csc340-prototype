package com.csc340.api_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public List<Customer> getCustomersByMajor(String major) {
        return customerRepository.getCustomersByMajor(major);
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(int customerId, Customer customer) {
        Customer existing = getCustomerById(customerId);
        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setPassword(customer.getPassword());
        existing.setAccountStatus(customer.getAccountStatus());
        existing.setMajor(customer.getMajor());
        existing.setEvents(customer.getEvents());
        existing.setGames(customer.getGames());

        customerRepository.save(existing);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
