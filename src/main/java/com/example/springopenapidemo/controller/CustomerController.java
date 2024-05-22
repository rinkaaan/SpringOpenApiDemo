package com.example.springopenapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springopenapidemo.entity.Customer;
import com.example.springopenapidemo.entity.CustomerDtoRepository;
import com.example.springopenapidemo.entity.CustomerRepository;
import com.example.springopenapidemo.entity.CustomerSaveDto;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final CustomerDtoRepository customerDtoRepository;

    public CustomerController(CustomerRepository customerRepository, CustomerDtoRepository customerDtoRepository) {
        this.customerRepository = customerRepository;
        this.customerDtoRepository = customerDtoRepository;
    }

    @GetMapping("/customer")
    public Customer hello() {
        return new Customer("John", "Doe");
    }

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/find-by-last-name")
    public Iterable<Customer> getCustomersByLastName(@RequestParam String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody CustomerSaveDto customer) {
        return customerDtoRepository.save(customer);
    }
}

