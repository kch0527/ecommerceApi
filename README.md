# ecommerceApi
- msa 아키텍처 학습을 위한 ecommerceApi
- 개발기간 2024.05 ~ 2024.08


</br>

🖥️ Stacks
---------  
- Java 17</br>
- Spring boot 3.2.5</br>
- Spring cloud, gateway, eureka</br>
- JPA, Querydsl</br>
- MariaDB</br>
- Kafka</br>
- Swagger

</br>

🏃 기여
---------
- 모듈화된 애플리케이션 백엔드개발 </br>
- Spring cloud를 활용한 MSA 아키텍처 구축 </br>
- Kafka를 통한 데이터 처리 </br>
- Swagger를 이용한 문서 </br>

</br>

Guide
---------
### kafka Source Connector
```
$ docker network create --gateway 172.18.0.1 --subnet 172.18.0.0/16 ecommerce-network
```

### kafka Sink Connector
```
$ docker network create --gateway 172.18.0.1 --subnet 172.18.0.0/16 ecommerce-network
```

### Docker Network
```
$ docker network create --gateway 172.18.0.1 --subnet 172.18.0.0/16 ecommerce-network
```

</br>

📖 디렉토리 구조
---------
### user-service

```
├─ client
│  └─ OrderServiceClient.java
│  │  
├─ config
│  └─ MetricsConfig.java
│  └─ Resilience4JConfig.java
│  └─ SwaggerConfig.java
│  │  
├─ controller
│  └─ UserController.java
│  │  
├─ entity
│  └─ UserEditor.java
│  └─ UserEntity.java
│  │  
├─ exception
│  └─ FeignException.java
│  │  
├─ repository
│  └─ UserRepository.java
│  │  
├─ request
│  └─ ReqLogin.java
│  └─ ReqUser.java
│  │ 
├─ response
│  └─ ResOrder.java
│  └─ ResUser.java
│  │
├─ security
│  └─ AuthenticationFilter.java
│  └─ WebSecurity.java
│  │ 
├─ service
│  └─ UserService.java
│  └─ UserServiceImpl.java
│  │ 
└─  UserServiceApplication.java
```

</br>

### order-service

``` 
├─ config
│  └─ SwaggerConfig.java
│  │  
├─ controller
│  └─ OrderController.java
│  │
├─ dto
│  └─ Field.java
│  └─ KafkaOrderDto.java
│  └─ Payload.java
│  └─ Schema.java
│  │  
├─ entity
│  └─ OrderEditor.java
│  │  
├─ kafka
│  └─ KafkaProducer.java
│  └─ KafkaProducerConfig.java
│  └─ OrderProducer.java
│  │  
├─ repository
│  └─ OrderRepository.java
│  │  
├─ request
│  └─ ReqOrder.java
│  │ 
├─ response
│  └─ ResOrder.java
│  │
├─ service
│  └─ OrderService.java
│  └─ OrderServiceImpl.java
│  │ 
└─  OrderServiceApplication.java
```

</br>

### catalog-service

``` 
├─ config
│  └─ QueryDslConfig.java
│  └─ SwaggerConfig.java
│  │  
├─ controller
│  └─ CatalogController.java
│  │
├─ entity
│  └─ CatalogEditor.java
│  │  
├─ kafka
│  └─ KafkaConsumer.java
│  └─ KafkaConsumerConfig.java
│  │  
├─ repository
│  └─ CatalogRepository.java
│  └─ CatalogRepositoryCustom.java
│  └─ CatalogRepositoryImpl.java
│  │  
├─ request
│  └─ ReqCatalog.java
│  └─ SearchCatalog.java
│  │ 
├─ response
│  └─ ResCatalog.java
│  │
├─ service
│  └─ CatalogService.java
│  └─ CatalogServiceImpl.java
│  │ 
└─  CatalogServiceApplication.java
```
