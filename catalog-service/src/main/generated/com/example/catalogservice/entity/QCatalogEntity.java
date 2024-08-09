package com.example.catalogservice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCatalogEntity is a Querydsl query type for CatalogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCatalogEntity extends EntityPathBase<CatalogEntity> {

    private static final long serialVersionUID = -933744334L;

    public static final QCatalogEntity catalogEntity = new QCatalogEntity("catalogEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath productId = createString("productId");

    public final StringPath productName = createString("productName");

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public final NumberPath<Integer> unitPrice = createNumber("unitPrice", Integer.class);

    public QCatalogEntity(String variable) {
        super(CatalogEntity.class, forVariable(variable));
    }

    public QCatalogEntity(Path<? extends CatalogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCatalogEntity(PathMetadata metadata) {
        super(CatalogEntity.class, metadata);
    }

}

