package com.example.cart_service.response;

import com.example.cart_service.entity.CartEntity;
import com.example.cart_service.entity.CartItemEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResCartItem {

    private Long id;
    private Long productId;
    private Integer qty;
    private Integer totalPrice;

    public ResCartItem(CartItemEntity cartItemEntity) {
        this.id = cartItemEntity.getId();
        this.productId = cartItemEntity.getProductId();
        this.qty = cartItemEntity.getQty();
        this.totalPrice = cartItemEntity.getTotalPrice();
    }

    @Builder
    public ResCartItem(Long id, Long productId, Integer qty, Integer totalPrice) {
        this.id = id;
        this.productId = productId;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }
}
