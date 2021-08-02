package org.example.emusicstore.service.impl;

import org.example.emusicstore.dao.CustomerDao;
import org.example.emusicstore.model.Customer;
import org.example.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
}
