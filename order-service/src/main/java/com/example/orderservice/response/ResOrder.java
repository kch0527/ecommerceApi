package com.example.orderservice.response;

import com.example.orderservice.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;

    public static ResOrder entityToRes(OrderEntity orderEntity) {
        return new ResOrder(orderEntity.getProductId(), orderEntity.getQty(),
                orderEntity.getUnitPrice(), orderEntity.getTotalPrice(),
                orderEntity.getCreatedAt(), orderEntity.getOrderId());
    }
}
