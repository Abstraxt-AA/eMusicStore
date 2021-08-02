package org.example.emusicstore.service;

import org.example.emusicstore.model.Cart;

public interface CartService {

    Cart getCartById(long cartId);

    void updateCart(Cart cart);
}
