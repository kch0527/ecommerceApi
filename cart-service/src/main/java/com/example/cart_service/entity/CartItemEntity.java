package com.example.cart_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Cart_Item")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @Builder
    public CartItemEntity(Long productId, Integer qty, Integer totalPrice, CartEntity cart) {
        this.productId = productId;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.cart = cart;
    }
}
