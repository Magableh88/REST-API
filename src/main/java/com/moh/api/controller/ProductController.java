package com.moh.api.controller;

import com.moh.api.model.Product;
import com.moh.api.service.ProductNotFoundException;
import com.moh.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/Product")
    public Product getProduct(@RequestParam Integer id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProductList();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) throws ProductNotFoundException {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) throws ProductNotFoundException {
        Product product = productService.deleteProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}