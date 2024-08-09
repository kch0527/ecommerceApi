package com.example.catalogservice.repository;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.request.SearchCatalog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepositoryCustom {

    List<CatalogEntity> getCatalogListWithPageAndSort(SearchCatalog searchCatalog);
}
