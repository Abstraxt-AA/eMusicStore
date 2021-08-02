package org.example.emusicstore.service.impl;

import org.example.emusicstore.dao.CustomerOrderDao;
import org.example.emusicstore.model.Cart;
import org.example.emusicstore.model.CartItem;
import org.example.emusicstore.model.CustomerOrder;
import org.example.emusicstore.service.CartService;
import org.example.emusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    CustomerOrderDao customerOrderDao;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(long cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotalPrice();
        }

        return grandTotal;
    }
}
