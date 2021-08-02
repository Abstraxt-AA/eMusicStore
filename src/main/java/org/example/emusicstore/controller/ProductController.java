package org.example.emusicstore.controller;

import org.example.emusicstore.model.Product;
import org.example.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String productList(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(Model model, @PathVariable long productId) throws IOException {

        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }
}
