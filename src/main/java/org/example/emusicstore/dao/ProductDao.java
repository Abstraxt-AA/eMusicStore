package org.example.emusicstore.dao;

import org.example.emusicstore.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(long id);

    List<Product> getProductList();

    void deleteProduct(Product product);

    void editProduct(Product product);
}
