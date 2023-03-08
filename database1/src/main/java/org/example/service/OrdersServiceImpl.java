package org.example.service;

import org.example.exceptions.OrderException;
import org.example.models.Order;
import org.example.models.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        ordersRepository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public int createOrder(Order order) {
        order.setId(0);
        return ordersRepository.save(order).getId();
    }

    @Override
    public boolean updateOrder(Order order) throws OrderException {
        if (!ordersRepository.existsById(order.getId())) {
            throw new OrderException("Id " + order.getId() + " does not exist");
        }
        return true;
    }

    @Override
    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Order getOrder(int id) {
        return ordersRepository.findById(id).get();
    }
}
