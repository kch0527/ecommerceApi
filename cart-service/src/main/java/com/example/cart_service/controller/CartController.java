package com.example.cart_service.controller;

import com.example.cart_service.request.ReqCart;
import com.example.cart_service.response.ResCartItem;
import com.example.cart_service.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-service")
@Slf4j
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/addItem")
    public void addItem(@RequestBody ReqCart reqCart){
        cartService.addItem(reqCart);
    }

    @GetMapping("/items/{userId}")
    public ResponseEntity<List<ResCartItem>> getCartItems(@PathVariable String userId){
        List<ResCartItem> resCartItems = cartService.getCartItems(userId);
        return ResponseEntity.status(HttpStatus.OK).body(resCartItems);
    }


    @DeleteMapping("/delItem/{id}")
    public void removeItem(@PathVariable Long id){
        cartService.removeItem(id);
    }
}
