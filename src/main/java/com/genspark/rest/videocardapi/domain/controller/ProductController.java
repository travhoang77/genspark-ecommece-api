package com.genspark.rest.videocardapi.domain.controller;

import com.genspark.rest.videocardapi.domain.entity.Product;
import com.genspark.rest.videocardapi.domain.entity.User;
import com.genspark.rest.videocardapi.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    public List<Product> getProducts()
    {
        return productService.get();
    }

    @GetMapping("/productByID/{productID}")
    public Product getProductById(@PathVariable String productID)
    {
        return productService.find(Long.parseLong(productID));
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product productToAdd)
    {
        return productService.create(productToAdd);
    }



    @PutMapping("/updateProduct")
    public Product updateProduct( @RequestBody Product productToUpdate)
    {
        return productService.update(productToUpdate);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody Product productToDelete)
    {
        productService.delete(productToDelete.getId());
    }

    @RequestMapping(value = "/productByType/{productType}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProductByType(@PathVariable String productType)
    {
        return productService.findByType(productType);
    }
}
