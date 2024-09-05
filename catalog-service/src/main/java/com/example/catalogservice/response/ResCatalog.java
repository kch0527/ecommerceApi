package com.example.catalogservice.response;

import com.example.catalogservice.entity.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Getter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResCatalog {
    private Long id;
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;

    public ResCatalog(CatalogEntity catalogEntity){
        this.id = catalogEntity.getId();
        this.productId = catalogEntity.getProductId();
        this.productName = catalogEntity.getProductName();
        this.unitPrice = catalogEntity.getUnitPrice();
        this.stock = catalogEntity.getStock();
    }

    @Builder
    public ResCatalog(Long id, String productId, String productName, Integer unitPrice, Integer stock) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
}
