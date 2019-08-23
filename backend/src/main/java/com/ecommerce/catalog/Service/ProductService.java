package com.ecommerce.catalog.Service;

import com.ecommerce.catalog.Entity.Product;
import com.ecommerce.catalog.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
        products = new ArrayList<Product>();
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> filterProductByTitle(String title) {
        return this.productRepository.filterProductByTitle(title);
    }

    public List<Product> getRandomProducts() {
        return this.productRepository.getRandomProducts();
    }
}
