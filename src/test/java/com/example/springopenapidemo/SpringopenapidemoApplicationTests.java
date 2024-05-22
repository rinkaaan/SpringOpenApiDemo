package com.example.springopenapidemo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.springopenapidemo.entity.Customer;
import com.example.springopenapidemo.entity.CustomerRepository;

@DataJpaTest
class SpringopenapidemoApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void createCustomer() {
        // Create a new customer
        Customer customer = new Customer("John", "Doe");
        // Save the customer
        customerRepository.save(customer);

        // Find the customer by last name
        Customer foundCustomer = customerRepository.findByLastName("Doe").get(0);
        // Check if the customer is found
        assert (foundCustomer.getFirstName().equals("John"));
    }

	@Test
	void printAllCustomers() {
		// Create a new customer
        Customer customer = new Customer("John", "Doe");
        // Save the customer
        customerRepository.save(customer);

		// Print all customers
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		for (Customer customerA : customers) {
			System.out.println(customerA);
		}
	}
}