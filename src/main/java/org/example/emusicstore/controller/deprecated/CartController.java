//package org.example.emusicstore.controller.deprecated;
//
//import org.example.emusicstore.dao.CartDao;
//import org.example.emusicstore.dao.ProductDao;
//import org.example.emusicstore.model.Cart;
//import org.example.emusicstore.model.CartItem;
//import org.example.emusicstore.model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("/rest/cart")
//public class CartController {
//
//    @Autowired
//    private CartDao cartDao;
//
//    @Autowired
//    private ProductDao productDao;
//
//    @RequestMapping("/{cartId}")
//    public @ResponseBody
//    Cart read(@PathVariable(value = "cartId") String cartId) {
//        return cartDao.read(cartId);
//    }
//
//    @PutMapping("/{cartId}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
//        cartDao.update(cartId, cart);
//    }
//
//    @DeleteMapping("/{cartId}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable(value = "cartId") String cartId) {
//        cartDao.delete(cartId);
//    }
//
//    @PutMapping("/add/{productId}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void addItem(@PathVariable(value = "productId") Product productId, HttpServletRequest request) {
//        String sessionId = request.getSession(true).getId();
//
//        Cart cart = cartDao.read(sessionId);
//        if (cart == null) {
//            cart = cartDao.create(new Cart(sessionId));
//        }
//
//        Product product = productDao.getProductById(productId);
//        if (product == null) {
//            throw new IllegalArgumentException(new Exception());
//        }
//
//        cart.addCartItem(new CartItem(product));
//
//        cartDao.update(sessionId, cart);
//    }
//
//    @DeleteMapping("/remove/{productId}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void removeItem(@PathVariable Product productId, HttpServletRequest request) {
//        String sessionId = request.getSession(true).getId();
//
//        Cart cart = cartDao.read(sessionId);
//        if (cart == null) {
//            cart = cartDao.create(new Cart(sessionId));
//        }
//
//        Product product = productDao.getProductById(productId);
//        if (product == null) {
//            throw new IllegalArgumentException(new Exception());
//        }
//
//        cart.removeCartItem(new CartItem(product));
//
//        cartDao.update(sessionId, cart);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
//    public void handleClientError(Exception e) {}
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
//    public void handleServerError(Exception e) {}
//}
