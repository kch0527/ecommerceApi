package com.example.orderservice.service;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.request.ReqOrder;
import com.example.orderservice.response.ResOrder;

import java.util.List;

public interface OrderService {
    ResOrder createOrder(ReqOrder reqOrder);
    ResOrder getOrderByOrderId(String orderId);
    List<ResOrder> getOrderByUserId(String userId);

    void sendOrderKafka(OrderEntity orderEntity);
}
