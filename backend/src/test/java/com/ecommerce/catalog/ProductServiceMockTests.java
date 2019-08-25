package com.ecommerce.catalog;

import com.ecommerce.catalog.Entity.Product;
import org.junit.Before;
import org.junit.Test;
import com.ecommerce.catalog.Repository.ProductRepository;
import com.ecommerce.catalog.Service.ProductService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceMockTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService = new ProductService();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(new ArrayList<Product>(
                Arrays.asList(
                        new Product(1, "product 1", 12, "brand 1", "image 1"),
                        new Product(2, "product 2", 13, "brand 2", "image 2"),
                        new Product(3, "product 3", 14, "brand 3", "image 3"),
                        new Product(4, "product 4", 15, "brand 4", "image 4"),
                        new Product(5, "product 5", 16, "brand 5", "image 5")
                )));

        List products = productService.getAllProducts();
        assertEquals(5, products.size());
    }

    @Test
    public void testFilterProductByTitle() {
        when(productRepository.filterProductByTitle("product")).thenReturn(new ArrayList<Product>(
                Arrays.asList(
                        new Product(1, "product 1", 12, "brand 1", "image 1"),
                        new Product(2, "product 2", 13, "brand 2", "image 2")
                )
        ));
        List products = productService.filterProductByTitle("product");
        assertEquals(2, products.size());
    }
}
