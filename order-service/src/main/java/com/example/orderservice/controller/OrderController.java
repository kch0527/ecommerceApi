package com.example.orderservice.controller;

import com.example.orderservice.request.ReqOrder;
import com.example.orderservice.response.ResOrder;
import com.example.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
@Slf4j
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResOrder> createOrder(@PathVariable("userId") String userId, @RequestBody ReqOrder reqOrder) {
        reqOrder.setUserId(userId);
        ResOrder resOrder = orderService.createOrder(reqOrder);
        return  ResponseEntity.status(HttpStatus.CREATED).body(resOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResOrder>> getOrders(@PathVariable("userId") String userId) throws Exception{
        List<ResOrder> orderList = orderService.getOrderByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
}
