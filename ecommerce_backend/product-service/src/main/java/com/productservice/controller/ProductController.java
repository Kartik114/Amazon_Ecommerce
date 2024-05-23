package com.productservice.controller;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.model.Product;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String Welcome()
    {
    	return "Welcome to product service";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{name}")
    public ProductResponse getProduct(@PathVariable String name){
        return productService.findProductByName(name);
    }

    @PutMapping("/{name}")
    public String updateProduct(@PathVariable String name, @RequestBody ProductRequest productRequest){
        productService.updateProduct(name, productRequest);
        return "Product updated";
    }
    @DeleteMapping
    public String deleteAll()
    {
        productService.delete();
        return "deleted";
    }
}
