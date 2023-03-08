package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.Order;

import java.util.List;

public interface OrdersService {

    List<Order> getOrders();

    int createOrder(Order order);

    boolean updateOrder(Order order) throws OrderException;

    void deleteOrder(int id);

    Order getOrder(int id);
}
