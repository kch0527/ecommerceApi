package com.example.cart_service.repository;

import com.example.cart_service.entity.CartItemEntity;
import com.example.cart_service.entity.QCartEntity;
import com.example.cart_service.entity.QCartItemEntity;
import com.example.cart_service.request.SearchCartItem;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartItemRepositoryImpl implements CartItemRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<CartItemEntity> getCartItemList(SearchCartItem searchCartItem) {
        QCartEntity cartEntity = QCartEntity.cartEntity;
        QCartItemEntity cartItemEntity = QCartItemEntity.cartItemEntity;

        return jpaQueryFactory.selectFrom(cartItemEntity)
                .join(cartItemEntity.cart, cartEntity)
                .where(cartEntity.userId.eq(searchCartItem.getUserId()))
                .offset(searchCartItem.getOffset())
                .limit(searchCartItem.getSize())
                .fetch();
    }
}
