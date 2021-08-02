package org.example.emusicstore.dao.impl;

import org.example.emusicstore.dao.CustomerDao;
import org.example.emusicstore.model.Authorities;
import org.example.emusicstore.model.Cart;
import org.example.emusicstore.model.Customer;
import org.example.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());
        newUser.setUsername(customer.getCustomerUsername());
        newUser.setPassword(customer.getCustomerPassword());

        Authorities newAuthority = new Authorities();
        newAuthority.setAuthority("ROLE_USER");
        newAuthority.setUsername(customer.getCustomerUsername());

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        session.saveOrUpdate(cart);
        session.saveOrUpdate(customer);

        session.flush();
    }

    @Override
    public Customer getCustomerById(long customerId) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = (Customer) session.get(Customer.class, customerId);
        session.flush();

        return customer;
    }

    @Override
    public Customer getCustomerByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where customerUsername = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

    @Override
    public List<Customer> getAllCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer");

        @SuppressWarnings("unchecked")
        List<Customer> customers = query.list();

        return customers;
    }
}
