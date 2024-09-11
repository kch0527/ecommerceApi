package com.example.cart_service.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartEntity is a Querydsl query type for CartEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartEntity extends EntityPathBase<CartEntity> {

    private static final long serialVersionUID = 341731559L;

    public static final QCartEntity cartEntity = new QCartEntity("cartEntity");

    public final ListPath<CartItemEntity, QCartItemEntity> cartItemEntityList = this.<CartItemEntity, QCartItemEntity>createList("cartItemEntityList", CartItemEntity.class, QCartItemEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath userId = createString("userId");

    public QCartEntity(String variable) {
        super(CartEntity.class, forVariable(variable));
    }

    public QCartEntity(Path<? extends CartEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCartEntity(PathMetadata metadata) {
        super(CartEntity.class, metadata);
    }

}

