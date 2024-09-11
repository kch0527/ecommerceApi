package com.example.cart_service.response;

import com.example.cart_service.entity.CartEntity;

public class ResCart {

    private String userId;

    public ResCart(String userId) {
        this.userId = userId;
    }

    public static ResCart entityToRes(CartEntity cartEntity){
        return new ResCart(cartEntity.getUserId());
    }
}
