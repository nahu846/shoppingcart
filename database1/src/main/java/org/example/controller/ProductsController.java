package org.example.controller;

import org.example.exceptions.OrderException;
import org.example.models.Product;
import org.example.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;
    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productsService.getProducts());
    }
    @PostMapping("products")
    public ResponseEntity<Integer> createProduct(@RequestBody Product product) throws OrderException {
        return ResponseEntity.ok(productsService.create(product));
    }
    @PutMapping("products")
    public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) throws OrderException {
        return ResponseEntity.ok(productsService.updateProduct(product));
    }
    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productsService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productsService.getProduct(id));
    }

}
