package org.example.emusicstore.controller.admin;

import org.example.emusicstore.model.Product;
import org.example.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;

    private Path path;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @PostMapping("/product/addProduct")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/"
                + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(path.toFile());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{productId}")
    public String addProduct(Model model, @PathVariable long productId) {
        Product product = productService.getProductById(productId);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @PostMapping("/product/editProduct")
    public String editProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/"
                + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(path.toFile());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable long productId, Model model,
                                HttpServletRequest request) {

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/"
                + productId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(productId);

        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}
