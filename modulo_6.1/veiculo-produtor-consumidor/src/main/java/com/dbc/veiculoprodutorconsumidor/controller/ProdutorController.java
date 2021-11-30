package com.dbc.veiculoprodutorconsumidor.controller;


import com.dbc.veiculoprodutorconsumidor.kafka.Producer;
import com.dbc.veiculoprodutorconsumidor.repository.ConsumerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.CarroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final Producer producer;
    private final ConsumerRepository consumerRepository;

    @PostMapping("/enviar")
    public void enviar(String mensagem) {
        producer.sendMessage(mensagem);
    }

    @PostMapping("/carro")
    public void enviarMensagemCarro(@RequestBody CarroDTO carroDTO) throws JsonProcessingException {
        producer.sendMessageDTO(carroDTO);
    }

    @GetMapping
    public List <CarroDTO> listar(){
        return consumerRepository.findAll();
    }
}
