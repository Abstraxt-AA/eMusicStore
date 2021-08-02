package org.example.emusicstore.controller.admin;

import org.example.emusicstore.model.Customer;
import org.example.emusicstore.model.Product;
import org.example.emusicstore.service.CustomerService;
import org.example.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {

        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerManagement";
    }
}
