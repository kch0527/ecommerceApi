package com.example.catalogservice.repository;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.entity.QCatalogEntity;
import com.example.catalogservice.request.SearchCatalog;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CatalogRepositoryImpl implements CatalogRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CatalogEntity> getCatalogListWithPageAndSort(SearchCatalog searchCatalog) {
        QCatalogEntity catalogEntity = QCatalogEntity.catalogEntity;

        return jpaQueryFactory.selectFrom(catalogEntity)
                .offset(searchCatalog.getOffset())
                .limit(searchCatalog.getSize())
                .orderBy(catalogEntity.id.desc())
                .fetch();
    }
}
