package org.example.emusicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.beans.Customizer;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = -8116563238278254074L;

    @Id
    @GeneratedValue
    private long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    //    private String cartId;
//    private Map<Long, CartItem> cartItems;
//    private double grandTotal;
//
//    private Cart() {
//        cartItems = new HashMap<>();
//        grandTotal = 0;
//    }
//
//    public Cart(String cartId) {
//        this();
//        this.cartId = cartId;
//    }
//
//    public Cart(String cartId, Map<Long, CartItem> cartItems, double grandTotal) {
//        this.cartId = cartId;
//        this.cartItems = cartItems;
//        this.grandTotal = grandTotal;
//    }
//
//    public String getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(String cartId) {
//        this.cartId = cartId;
//    }
//
//    public Map<Long, CartItem> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(Map<Long, CartItem> cartItems) {
//        this.cartItems = cartItems;
//    }
//
//    public double getGrandTotal() {
//        return grandTotal;
//    }
//
//    public void setGrandTotal(double grandTotal) {
//        this.grandTotal = grandTotal;
//    }
//
//    public void addCartItem(CartItem cartItem) {
//        long productId = cartItem.getProduct().getProductId();
//
//        if (cartItems.containsKey(productId)) {
//            CartItem existingCartItem = cartItems.get(productId);
//            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
//            cartItems.put(productId, existingCartItem);
//        } else {
//            cartItems.put(productId, cartItem);
//        }
//
//        updateGrandTotal();
//    }
//
//    public void removeCartItem(CartItem cartItem) {
//        long productId = cartItem.getProduct().getProductId();
//        cartItems.remove(productId);
//        updateGrandTotal();
//    }
//
//    public void updateGrandTotal() {
//        grandTotal = 0;
//        for (CartItem cartItem : cartItems.values()) {
//            grandTotal += cartItem.getTotalPrice();
//        }
//    }
}
