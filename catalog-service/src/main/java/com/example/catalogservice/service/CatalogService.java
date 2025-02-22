package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.request.SearchCatalog;
import com.example.catalogservice.response.ResCatalog;

import java.util.List;

public interface CatalogService {

    List<ResCatalog> getCatalogListWithPageAndSort(SearchCatalog searchCatalog);

    ResCatalog getCatalog(Long id);
}
