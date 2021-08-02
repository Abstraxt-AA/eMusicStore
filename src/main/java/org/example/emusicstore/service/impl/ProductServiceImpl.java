package org.example.emusicstore.service.impl;

import org.example.emusicstore.dao.ProductDao;
import org.example.emusicstore.model.Product;
import org.example.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    @Override
    public Product getProductById(long id) {
        return productDao.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
