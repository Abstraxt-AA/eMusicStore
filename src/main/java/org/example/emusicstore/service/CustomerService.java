package org.example.emusicstore.service;

import org.example.emusicstore.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(long customerId);

    Customer getCustomerByUsername(String username);

    List<Customer> getAllCustomers();
}
