package com.example.orderservice.request;

import lombok.Data;

@Data
public class ReqOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private String userId;
    private String orderId;
}
