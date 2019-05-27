package vn.codegym.springbootdatajpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.springbootdatajpa.entities.Product;

import javax.persistence.*;
import java.util.*;

@Service
public class ProductDaoServiceImpl implements ProductDaoService {
    @Autowired EntityManager entityManager;
    @Override public Optional<Product> get(long id) {
        return null;
    }

    @Override public List<Product> getAll() {
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("select p from Product p", Product.class);
        return productTypedQuery.getResultList();
    }

    @Override public void save(Product product) {

    }

    @Override public void update(Product product, String[] params) {

    }

    @Override public void delete(Product product) {

    }

    @Override public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }
}
