package com.example.catalogservice.service;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.example.catalogservice.response.ResCatalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService{
    CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<ResCatalog> getCatalogs(){
        Iterable<CatalogEntity> catalogList = catalogRepository.findAll();

        List<ResCatalog> result = new ArrayList<>();
        catalogList.forEach(c -> {
            result.add(ResCatalog.entityToRes(c));
        });
        return result;
    }
}
