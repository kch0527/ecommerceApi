package com.example.cart_service.service;

import com.example.cart_service.entity.CartEntity;
import com.example.cart_service.request.ReqCart;
import com.example.cart_service.request.SearchCartItem;
import com.example.cart_service.response.ResCartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    CartEntity createCart(String userId);

    void addItem(ReqCart reqCart);

    List<ResCartItem> getCartItems(String userId);

    void removeItem(Long id);

}
