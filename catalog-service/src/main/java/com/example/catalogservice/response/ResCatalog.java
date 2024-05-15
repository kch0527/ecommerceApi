package com.example.catalogservice.response;

import com.example.catalogservice.entity.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;

    public static ResCatalog entityToRes(CatalogEntity catalogEntity) {
        return new ResCatalog(catalogEntity.getProductId(), catalogEntity.getProductName(), 
                catalogEntity.getUnitPrice(), catalogEntity.getStock());
    }
}
