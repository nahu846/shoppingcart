package org.example.controller;

import org.example.exceptions.OrderException;
import org.example.models.OrderItem;
import org.example.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OItemController {

    @Autowired
    OrderItemsService orderItemsService;

    @GetMapping("orderitems")
    public ResponseEntity<List<OrderItem>> getOrders() {
        return ResponseEntity.ok(orderItemsService.getOrders());
    }

    @PostMapping("orderitems")
    public ResponseEntity<Integer> createOrder(@RequestBody OrderItem orderItem) throws OrderException {
        return ResponseEntity.ok(orderItemsService.createOrder(orderItem));
    }

    @PutMapping("orderitems")
    public ResponseEntity<Boolean> updateOrder(@RequestBody OrderItem orderItem) throws OrderException {
        return ResponseEntity.ok(orderItemsService.updateOrder(orderItem));
    }

    @DeleteMapping("orderitems/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id) {
        orderItemsService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("orderitems/{id}")
    public ResponseEntity<OrderItem> getOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderItemsService.getOrder(id));
    }
}
