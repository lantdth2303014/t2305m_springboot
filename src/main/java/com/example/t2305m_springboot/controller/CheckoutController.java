package com.example.t2305m_springboot.controller;

import com.example.t2305m_springboot.dto.req.CancelOrderReq;
import com.example.t2305m_springboot.dto.req.OrderReq;
import com.example.t2305m_springboot.dto.req.UpOrderStatReq;
import com.example.t2305m_springboot.entity.Order;
import com.example.t2305m_springboot.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class CheckoutController {
    private final OrderService orderService;

    public CheckoutController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestBody OrderReq req) {
        return ResponseEntity.ok(orderService.createOrder(req));
    }

    @PutMapping("/status")
    public ResponseEntity<Order> updateOrderStatus(@RequestBody UpOrderStatReq request) {
        return ResponseEntity.ok(orderService.updateOrderStatus(request));
    }

    @PutMapping("/cancel")
    public ResponseEntity<Order> cancelOrder(@RequestBody CancelOrderReq request) {
        return ResponseEntity.ok(orderService.cancelOrder(request));
    }
}
