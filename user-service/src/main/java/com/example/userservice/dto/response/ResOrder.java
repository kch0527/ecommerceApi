package com.example.userservice.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResOrder {
    private String productId;
    private Integer qty;
    private Integer price;
    private Integer totalPrice;
    private Date orderDt;

    private String orderId;
}
