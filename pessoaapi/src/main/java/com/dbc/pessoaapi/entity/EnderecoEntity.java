package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoEntity {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @NotEmpty
    @NotBlank
    @Size(max = 250)
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;
    @NotEmpty
    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotBlank
    @NotEmpty
    @Size(max = 250)
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String pais;

}
