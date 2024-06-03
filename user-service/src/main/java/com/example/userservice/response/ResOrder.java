package com.example.userservice.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;

    private String orderId;
}
