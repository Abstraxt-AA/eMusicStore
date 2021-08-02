package org.example.emusicstore.controller;

import org.example.emusicstore.model.Cart;
import org.example.emusicstore.model.CartItem;
import org.example.emusicstore.model.Customer;
import org.example.emusicstore.model.Product;
import org.example.emusicstore.service.CartItemService;
import org.example.emusicstore.service.CartService;
import org.example.emusicstore.service.CustomerService;
import org.example.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable long cartId) {
        return cartService.getCartById(cartId);
    }

    @PutMapping("/add/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable long productId, @AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);

        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            if (product.getProductId() == cartItem.getProduct().getProductId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @DeleteMapping("/remove/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable long productId) {
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAllItems(@PathVariable long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors(Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors(Exception e) {}
}
