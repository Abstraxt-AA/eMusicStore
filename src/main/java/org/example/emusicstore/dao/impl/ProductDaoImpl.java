package org.example.emusicstore.dao.impl;

import org.example.emusicstore.dao.ProductDao;
import org.example.emusicstore.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    @Override
    public Product getProductById(long id) {

        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();
        return product;
    }

    @Override
    public List<Product> getProductList() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        @SuppressWarnings("unchecked")
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    @Override
    public void deleteProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    @Override
    public void editProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }
}
