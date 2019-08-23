package com.ecommerce.catalog.Repository;

import com.ecommerce.catalog.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.title LIKE CONCAT('%', :title, '%')")
    List<Product> filterProductByTitle(@Param("title") String title);

    @Query("SELECT p FROM Product p ORDER BY rand()")
    List<Product> getRandomProducts();
}
