package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.Product;
import org.example.models.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productsRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public int create(Product product) throws OrderException {
        product.setId(0);
//        if (productsRepository.existsById(product.getId())) {
//            throw new OrderException("");
//        }
        return productsRepository.save(product).getId();
    }

    @Override
    public boolean updateProduct(Product product) throws OrderException {
        if (!productsRepository.existsById(product.getId())) {
            throw new OrderException("Product id " + product.getId() + " does not exist");
        }
        productsRepository.save(product);
        return true;
    }

    @Override
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Product getProduct(int id) {
        return productsRepository.findById(id).get();
    }
}
