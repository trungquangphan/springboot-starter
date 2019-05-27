package vn.codegym.springbootdatajpa.dao;

import vn.codegym.springbootdatajpa.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDaoService extends Dao<Product> {
    Product findById(long id);
}