//package org.example.emusicstore.controller.deprecated;
//
//import org.example.emusicstore.dao.ProductDao;
//import org.example.emusicstore.model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//@Controller
//public class AdminController {
//
//    private Path path;
//
//    @Autowired
//    private ProductDao productDao;
//
//    @RequestMapping("/admin")
//    public String adminPage() {
//        return "admin";
//    }
//
//    @RequestMapping("/admin/productInventory")
//    public String productInventory(Model model) {
//        List<Product> products = productDao.getProductList();
//        model.addAttribute("products", products);
//
//        return "productInventory";
//    }
//
//    @RequestMapping("/admin/productInventory/addProduct")
//    public String addProduct(Model model) {
//        Product product = new Product();
//        product.setProductCategory("Instrument");
//        product.setProductCondition("New");
//        product.setProductStatus("Active");
//
//        model.addAttribute("product", product);
//
//        return "addProduct";
//    }
//
//    @PostMapping("/admin/productInventory/addProduct")
//    public String addProduct(@Valid @ModelAttribute("product") Product product,
//                             BindingResult result, HttpServletRequest request) {
//        if (result.hasErrors()) {
//            return "addProduct";
//        }
//
//        productDao.addProduct(product);
//
//        MultipartFile productImage = product.getProductImage();
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");
//
//        if (productImage != null && !productImage.isEmpty()) {
//            try {
//                productImage.transferTo(new File(path.toString()));
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException("Product image saving failed", e);
//            }
//        }
//
//        return "redirect:/admin/productInventory";
//    }
//
//    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
//    public String deleteProduct(@PathVariable Product productId, Model model, HttpServletRequest request) {
//
//        productDao.deleteProduct(productId);
//
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + productId + ".png");
//
//        if (Files.exists(path)) {
//            try {
//                Files.delete(path);
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException("Product image deleting failed", e);
//            }
//        }
//
//        return "redirect:/admin/productInventory";
//    }
//
//    @RequestMapping("/admin/productInventory/editProduct/{productId}")
//    public String editProduct(@PathVariable Product productId, Model model) {
//
//        Product product = productDao.getProductById(productId);
//
//        model.addAttribute(product);
//
//        return "editProduct";
//    }
//
//    @PostMapping("/admin/productInventory/editProduct")
//    public String editProduct(@Valid @ModelAttribute("product") Product product,
//                              BindingResult result, Model model, HttpServletRequest request) {
//
//        if (result.hasErrors()) {
//            return "editProduct";
//        }
//
//        MultipartFile productImage = product.getProductImage();
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png");
//
//        if (productImage != null && !productImage.isEmpty()) {
//            try {
//                productImage.transferTo(new File(path.toString()));
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException("Product image saving failed", e);
//            }
//        }
//
//        productDao.editProduct(product);
//
//        return "redirect:/admin/productInventory";
//    }
//}
//
