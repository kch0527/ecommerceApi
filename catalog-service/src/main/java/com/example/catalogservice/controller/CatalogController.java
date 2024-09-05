package com.example.catalogservice.controller;

import com.example.catalogservice.request.SearchCatalog;
import com.example.catalogservice.response.ResCatalog;
import com.example.catalogservice.service.CatalogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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
    public List<ResCatalog> getCatalogs(@ModelAttribute SearchCatalog searchCatalog) {
        return catalogService.getCatalogListWithPageAndSort(searchCatalog);
    }

    @Operation(summary = "제품 상세을 위한 API", description = "catalog-service에 제품 상세을 위한 API")
    @GetMapping("/catalogs/{id}")
    public ResCatalog getCatalog(@PathVariable Long id){
        return catalogService.getCatalog(id);
    }
}
