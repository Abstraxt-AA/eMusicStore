package org.example.emusicstore.dao;

import org.example.emusicstore.model.Cart;
import org.example.emusicstore.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(long productId);
}
