package org.example.emusicstore.dao.impl;

import org.example.emusicstore.dao.CartDao;
import org.example.emusicstore.model.Cart;
import org.example.emusicstore.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Override
    public Cart getCartById(long cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.get(Cart.class, cartId);
        session.flush();
        return cart;
    }

    @Override
    public void updateCart(Cart cart) {
        long cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    @Override
    public Cart validate(long cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId+"");
        }
        updateCart(cart);
        return cart;
    }
}
