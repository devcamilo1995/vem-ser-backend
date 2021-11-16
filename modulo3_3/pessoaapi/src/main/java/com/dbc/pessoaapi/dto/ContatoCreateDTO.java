package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import io.swagger.annotations.ApiModelProperty;
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
public class ContatoCreateDTO {
    @ApiModelProperty(value= "ID da Pessoa")
    private Integer idPessoa;
    @NotNull
    @ApiModelProperty(value= "Tipo do contato")
    private TipoContato tipoContato;
    @NotEmpty
    @Size(max=13, min=13)
    @ApiModelProperty(value= "Numero do telefone")
    private String numero;
    @NotEmpty
    @NotBlank
    @ApiModelProperty(value= "Descricão")
    private String descricao;
}
