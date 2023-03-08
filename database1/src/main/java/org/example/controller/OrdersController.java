package org.example.controller;

import org.example.exceptions.OrderException;
import org.example.models.Order;
import org.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(ordersService.getOrders());
    }

    @PostMapping("orders")
    public ResponseEntity<Integer> createOrders(@RequestBody Order order) {
        return ResponseEntity.ok(ordersService.createOrder(order));
    }

    @PutMapping("orders")
    public ResponseEntity<Boolean> updateOrders(@RequestBody Order order) throws OrderException {
        return ResponseEntity.ok(ordersService.updateOrder(order));
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable int id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) {
        return ResponseEntity.ok(ordersService.getOrder(id));
    }

//    @PatchMapping("orders")
}
