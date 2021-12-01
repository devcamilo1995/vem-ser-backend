package com.dbc.chatkafka.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MensagemDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;
}
