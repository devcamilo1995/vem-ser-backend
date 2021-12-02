package com.dbc.pessoapiconsumidor.dto;

import lombok.Data;

@Data
public class EmailDTO {
    private String destinatario;
    private String assunto;
    private String texto;
}
