package com.example.cart_service.request;

import lombok.Getter;

@Getter
public class ReqCart {

    private String userId;
    private Long productId;
    private Integer qty;
    private Integer totalPrice;
}
