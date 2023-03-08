package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.Product;

import java.util.List;

public interface ProductsService {

    List<Product> getProducts();
    int create(Product product) throws OrderException;
    boolean updateProduct(Product product) throws OrderException;
    void deleteProduct(int id);
    Product getProduct(int id);

}
