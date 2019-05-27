package vn.codegym.springbootdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.springbootdatajpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query(value = "select * from product", nativeQuery = true)
    Product findFirstByName(String bmw);
}
