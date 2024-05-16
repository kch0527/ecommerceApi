package com.example.orderservice.service;

import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.request.ReqOrder;
import com.example.orderservice.response.ResOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResOrder createOrder(ReqOrder reqOrder) {
        OrderEntity orderEntity = OrderEntity.builder()
                .productId(reqOrder.getProductId())
                .qty(reqOrder.getQty())
                .unitPrice(reqOrder.getUnitPrice())
                .totalPrice(reqOrder.getQty() * reqOrder.getUnitPrice())
                .userId(reqOrder.getUserId())
                .orderId(UUID.randomUUID().toString())
                .build();
        orderRepository.save(orderEntity);

        ResOrder resOrder = ResOrder.entityToRes(orderEntity);
        return resOrder;

    }

    @Override
    public ResOrder getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        ResOrder resOrder = ResOrder.entityToRes(orderEntity);
        return resOrder;
    }

    @Override
    public List<ResOrder> getOrderByUserId(String userId) {
        Iterable<OrderEntity> orderList = orderRepository.findByUserId(userId);

        List<ResOrder> result = new ArrayList<>();
        orderList.forEach(o -> {
            result.add(ResOrder.entityToRes(o));
        });
        return result;
    }
}
