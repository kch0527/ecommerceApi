package com.example.catalogservice.repository;

import com.example.catalogservice.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<CatalogEntity, Long>, CatalogRepositoryCustom {

    CatalogEntity findByProductId(String productId);
}
