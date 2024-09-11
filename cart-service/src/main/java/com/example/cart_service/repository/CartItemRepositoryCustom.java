package com.example.cart_service.repository;

import com.example.cart_service.entity.CartItemEntity;
import com.example.cart_service.request.SearchCartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepositoryCustom {

    List<CartItemEntity> getCartItemList(SearchCartItem searchCartItem);
}
