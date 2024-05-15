package com.example.catalogservice.request;

import lombok.Data;

@Data
public class ReqCatalog {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;
}
