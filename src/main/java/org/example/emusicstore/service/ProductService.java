package org.example.emusicstore.service;

import org.example.emusicstore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(long id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
