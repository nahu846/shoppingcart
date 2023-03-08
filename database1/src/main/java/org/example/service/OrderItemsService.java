package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.OrderItem;

import java.util.List;

public interface OrderItemsService {

    List<OrderItem> getOrders();

    int createOrder(OrderItem orderItem) throws OrderException;

    boolean updateOrder(OrderItem orderItem) throws OrderException;

    void deleteOrder(int id);

    OrderItem getOrder(int id);
}
