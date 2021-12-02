package com.dbc.chatkafka.controller;


import com.dbc.chatkafka.dto.ChatDTO;
import com.dbc.chatkafka.kafka.Producer;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;

    @PostMapping("/mensagem-especifica")
    public void enviarMensagemEspecifica(@RequestBody ChatDTO chatDTO) throws JsonProcessingException {
        producer.sendMessageEspecifica(chatDTO);
    }

    @PostMapping
    public void enviarMensagemGeral(@RequestBody MensagemDTO mensagemDTO) throws JsonProcessingException {
        producer.sendMessageGeral(mensagemDTO);
    }
}
