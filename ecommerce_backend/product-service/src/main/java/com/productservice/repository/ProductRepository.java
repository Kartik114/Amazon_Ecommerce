package com.productservice.repository;


import com.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Optional<Product> findByName(String name);
    public void deleteByName(String name);
}
