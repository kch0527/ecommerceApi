package com.example.catalogservice.controller;

import com.example.catalogservice.request.SearchCatalog;
import com.example.catalogservice.response.ResCatalog;
import com.example.catalogservice.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Operation(summary = "제품 목록을 위한 API", description = "catalog-service에 제품 목록을 위한 API")
    @GetMapping("/catalogs")
    public ResponseEntity<List<ResCatalog>> getCatalogs(SearchCatalog searchCatalog) {
        List<ResCatalog> resCatalogs = catalogService.getCatalogListWithPageAndSort(searchCatalog);
        return ResponseEntity.status(HttpStatus.OK).body(resCatalogs);
    }

    @Operation(summary = "제품 상세을 위한 API", description = "catalog-service에 제품 상세을 위한 API")
    @GetMapping("/catalogs/{id}")
    public ResponseEntity<ResCatalog> getCatalog(@PathVariable Long id){
        ResCatalog resCatalog = catalogService.getCatalog(id);
        return ResponseEntity.status(HttpStatus.OK).body(resCatalog);
    }
}
