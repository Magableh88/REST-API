package com.moh.api.repo;
import com.moh.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findById(Integer id);

    List<Product> findAll();

    List<Product> deleteById(Integer id);

    boolean existsById(int id);

}
