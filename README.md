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
- Swagger</br>
- Docker

</br>

🏃 기여
---------
- Spring cloud를 활용한 MSA아키텍처 구축 </br>
  1. 각 서비스별 모듈화된 애플리케이션 백엔드 개발 </br>
  2. Eureka & Gateway를 활용한 서비스 간 호출 관리 </br>
  3. Spring Cloud Config를 활용한 외부 설정 정보 관리 </br>
- 회원가입 및 로그인 </br>
  1. 회원가입시 비밀번호 암호화 처리 </br>
  2. 로그인시 JWT를 활용한 인증 </br>
- Kafka를 통한 데이터 처리 </br>
  1. 물건 구매시 Kafka를 활용해 재고 수량 실시간 업데이트 </br>
- Swagger를 활용한 문서화 </br>
  1. 각 서비스별 API 문서화 생성 및 관리 </br>
- Docker를 활용한 가상화 </br>
  1. 각 서비스별 컨테이너화 및 가상 환경 구축 </br>
  2. Docker Network 사용한 서비스 간 네트워크 관리 및 통신 설정 </br>

</br>

Guide
---------
### ecommerce-front
https://github.com/kch0527/ecommerce-front

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
