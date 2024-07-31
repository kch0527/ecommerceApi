package com.example.catalogservice.kafka;

import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {
    CatalogRepository catalogRepository;

    @Autowired
    public KafkaConsumer(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    @KafkaListener(topics = "catalog-topic")
    public void updateQty(String kafkaMessage) {
        log.info("kafka Message:" + kafkaMessage);

        Map<Object, Object> map;
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        }catch (JsonProcessingException e) {
            log.error("Error JSON message: {}", kafkaMessage, e);
            return;
        }

        CatalogEntity catalogEntity = catalogRepository.findByProductId((String)map.get("productId"));

        if(catalogEntity == null){
            log.warn("not found", (String) map.get("productId"));
            return;
        }

        int currentStock = catalogEntity.getStock();
        int orderQty = (Integer) map.get("qty");

        if(currentStock < orderQty){
            log.error("Insufficient stock - requested {}, available {}", orderQty, currentStock);
            return;
        }

        catalogEntity.setStock(catalogEntity.getStock() - (Integer) map.get("qty"));
        catalogRepository.save(catalogEntity);
        log.info("Stock updated");
    }
}
