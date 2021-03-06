package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.repository.ConsumerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CarroDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ConsumerRepository consumerRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.dto}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory"
    )
    public void consume(@Payload String mensagem,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        CarroDTO carroDTO = objectMapper.readValue(mensagem, CarroDTO.class);
        log.info("MENSAGEM LIDA: '{}', CHAVE: '{}', OFFSET: '{}'", mensagem, key, offset);
        consumerRepository.save(carroDTO);



    }

}
