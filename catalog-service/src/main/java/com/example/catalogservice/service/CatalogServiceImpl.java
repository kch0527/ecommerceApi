package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.example.catalogservice.request.SearchCatalog;
import com.example.catalogservice.response.ResCatalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService{
    CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    public List<ResCatalog> getCatalogListWithPageAndSort(SearchCatalog searchCatalog){
        return catalogRepository.getCatalogListWithPageAndSort(searchCatalog)
                .stream()
                .map(ResCatalog::new)
                .collect(Collectors.toList());
    }

    public ResCatalog getCatalog(Long id){
        CatalogEntity catalogEntity = catalogRepository.findById(id).orElseThrow();

        return ResCatalog.builder()
                .productId(catalogEntity.getProductId())
                .productName(catalogEntity.getProductName())
                .stock(catalogEntity.getStock())
                .unitPrice(catalogEntity.getUnitPrice())
                .build();
    }
}
