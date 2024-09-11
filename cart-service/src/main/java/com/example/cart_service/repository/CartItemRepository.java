package com.example.cart_service.repository;

import com.example.cart_service.entity.CartEntity;
import com.example.cart_service.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity,Long>, CartItemRepositoryCustom {

    Optional<CartItemEntity> findByCartAndProductId(CartEntity cart, Long productId);
}
