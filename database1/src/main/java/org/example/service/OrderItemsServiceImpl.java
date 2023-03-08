package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.OrderItem;
import org.example.models.OrderItemsRepository;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    ProductsService productsService;

    @Override
    public List<OrderItem> getOrders() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItemsRepository.findAll().forEach(orderItems::add);
        return orderItems;
    }

    @Override
    public int createOrder(OrderItem orderItem) throws OrderException {
        orderItem.setId(0);
//        if (ordersRepository.existsById(orderItem.getId())) {
//            throw new OrderException("Id " + orderItem.getId() + " already exists");
//        }
        return saveOrder(orderItem);
    }

    @Override
    public boolean updateOrder(OrderItem orderItem) throws OrderException {
        if (!orderItemsRepository.existsById(orderItem.getId())) {
            throw new OrderException("Order id " + orderItem.getId() + " does not exist");
        }
        saveOrder(orderItem);
        return true;
    }

    @Override
    public void deleteOrder(int id) {
        orderItemsRepository.deleteById(id);
    }

    @Override
    public OrderItem getOrder(int id) {
        return orderItemsRepository.findById(id).get();
    }

    private boolean productStockIsEnough(OrderItem orderItem) throws OrderException {

        Product product = productsService.getProduct(orderItem.getId());
        if (orderItem.getQuantity() <= product.getStock()) {
            product.setStock(product.getStock() - orderItem.getQuantity());
            productsService.updateProduct(product);
            return true;
        }
        return false;
    }

    private int saveOrder(OrderItem orderItem) throws OrderException {
        if (productStockIsEnough(orderItem)) {
            return orderItemsRepository.save(orderItem).getId();
        }
        throw new OrderException("Not enough stock");

    }


}
