package com.csc340.api_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getOneCustomer(@PathVariable int customerId) {
        return service.getCustomerById(customerId);
    }

    @GetMapping("")
    public List<Customer> getCustomersByMajor(@RequestParam(name = "major", defaultValue = "csc") String major) {
        return service.getCustomersByMajor(major);
    }

    @PostMapping("/new")
    public List<Customer> addNewCustomer(@RequestBody Customer customer) {
        service.addNewCustomer(customer);
        return service.getAllCustomers();
    }

    @PutMapping("/update/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return service.getCustomerById(customerId);
    }

    @DeleteMapping("/delete/{customerId}")
    public List<Customer> deleteCustomerById(@PathVariable int customerId) {
        service.deleteCustomerById(customerId);
        return service.getAllCustomers();
    }
}
