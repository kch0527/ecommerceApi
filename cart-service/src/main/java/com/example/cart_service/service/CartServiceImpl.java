package com.example.cart_service.service;

import com.example.cart_service.entity.CartEntity;
import com.example.cart_service.entity.CartItemEntity;
import com.example.cart_service.repository.CartItemRepository;
import com.example.cart_service.repository.CartRepository;
import com.example.cart_service.request.ReqCart;
import com.example.cart_service.request.SearchCartItem;
import com.example.cart_service.response.ResCartItem;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    @Override
    public CartEntity createCart(String userId) {
        CartEntity cartEntity = CartEntity.builder()
                .userId(userId)
                .build();
        return cartRepository.save(cartEntity);
    }

    @Transactional
    @Override
    public void addItem(ReqCart reqCart){

        CartEntity cartEntity = cartRepository.findByUserIdWithLock(reqCart.getUserId())
                .orElseGet(() -> createCart(reqCart.getUserId()));

        Optional<CartItemEntity> existCartItem = cartItemRepository
                .findByCartAndProductId(cartEntity, reqCart.getProductId());

        if(existCartItem.isPresent()){
            CartItemEntity cartItem = existCartItem.get();
            cartItem.setQty(cartItem.getQty() + reqCart.getQty());
            cartItem.setTotalPrice(cartItem.getTotalPrice() + reqCart.getTotalPrice());
            cartItemRepository.save(cartItem);
        }else{
            CartItemEntity cartItemEntity = CartItemEntity.builder()
                    .productId(reqCart.getProductId())
                    .qty(reqCart.getQty())
                    .totalPrice(reqCart.getTotalPrice())
                    .cart(cartEntity)
                    .build();
            cartItemRepository.save(cartItemEntity);
        }
    }

    @Override
    public List<ResCartItem> getCartItems(String userId){
        SearchCartItem searchCartItem = SearchCartItem.builder()
                .userId(userId)
                .build();
        return cartItemRepository.getCartItemList(searchCartItem)
                .stream()
                .map(ResCartItem::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void removeItem(Long id){
        cartItemRepository.deleteById(id);
    }
}
