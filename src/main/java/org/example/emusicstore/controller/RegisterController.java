package org.example.emusicstore.controller;

import org.example.emusicstore.model.BillingAddress;
import org.example.emusicstore.model.Customer;
import org.example.emusicstore.model.ShippingAddress;
import org.example.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        customer.setBillingAddress(new BillingAddress());
        customer.setShippingAddress(new ShippingAddress());

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @PostMapping("/register")
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                   BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customers = customerService.getAllCustomers();

        for (Customer checkCustomer : customers) {
            if (customer.getCustomerEmail().equals(checkCustomer.getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists.");

                return "registerCustomer";
            }
            if (customer.getCustomerUsername().equals(checkCustomer.getCustomerUsername())) {
                model.addAttribute("usernameMsg", "Username already exists.");

                return "registerCustomer";
            }
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";
    }
}
