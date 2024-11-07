package com.spartan.esports.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // Get all customers
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{customerId}")
    public Customer getOneCustomer(@PathVariable Long customerId) {
        return service.getCustomerById(customerId);
    }

    // Get customers by major (optional query parameter)
    @GetMapping("")
    public List<Customer> getCustomersByMajor(@RequestParam(name = "major", defaultValue = "csc") String major) {
        return service.getCustomersByMajor(major);
    }

    // Add a new customer
    @PostMapping("/new")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        return service.addNewCustomer(customer);
    }

    // Update an existing customer
    @PutMapping("/update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        return service.updateCustomer(customerId, customer);
    }

    // Delete a customer by ID
    @DeleteMapping("/delete/{customerId}")
    public List<Customer> deleteCustomerById(@PathVariable Long customerId) {
        service.deleteCustomerById(customerId);
        return service.getAllCustomers();
    }
}
