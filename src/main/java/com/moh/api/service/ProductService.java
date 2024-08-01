package com.moh.api.service;

import com.moh.api.model.Product;
import com.moh.api.repo.ProductRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //private List<Product> productList;
    @Autowired
    private ProductRepo productRepo;

    public Product getProduct(Integer id) throws ProductNotFoundException {
        if(productRepo.existsById(id)) {
            return productRepo.findById(id);
        }
        throw new ProductNotFoundException((id));
    }

    public List<Product> getProductList() {
        return (List<Product>) productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return (Product) productRepo.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails) throws ProductNotFoundException {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepo.findById(id));
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            return (Product) productRepo.save(existingProduct);
        } else {
            // Handle the case when the product with the given ID does not exist
            throw new ProductNotFoundException(id);
        }
    }

    public Product deleteProduct(Integer id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepo.findById(id));
        if(optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            productRepo.delete(existingProduct);
            return existingProduct;
        }
        else{
            throw new ProductNotFoundException(id);
        }
    }

}
