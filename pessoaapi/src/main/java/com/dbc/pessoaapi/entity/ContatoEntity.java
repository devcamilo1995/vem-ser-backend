package com.dbc.pessoaapi.entity;

import lombok.*;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContatoEntity {
    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;
    private String descricao;

}
