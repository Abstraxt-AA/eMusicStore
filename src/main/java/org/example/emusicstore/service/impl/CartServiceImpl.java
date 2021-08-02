package org.example.emusicstore.service.impl;

import org.example.emusicstore.dao.CartDao;
import org.example.emusicstore.model.Cart;
import org.example.emusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(long cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}
