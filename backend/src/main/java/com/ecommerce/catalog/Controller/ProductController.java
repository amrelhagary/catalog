package com.ecommerce.catalog.Controller;

import com.ecommerce.catalog.Entity.Product;
import com.ecommerce.catalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "") String title) {
        if(title.length() > 0) {
            System.out.println("title: " + title);
            return this.productService.filterProductByTitle(title);
        } else {
            return this.productService.getAllProducts();
        }
    }

    @GetMapping("/product/random")
    public List<Product> getRandomProducts() {
       return this.productService.getRandomProducts();
    }
}
