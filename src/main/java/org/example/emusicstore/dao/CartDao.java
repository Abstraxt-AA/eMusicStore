package org.example.emusicstore.dao;

import org.example.emusicstore.model.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getCartById(long cartId);

    void updateCart(Cart cart);

    Cart validate(long cartId) throws IOException;
}
