package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
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
public class EnderecoCreateDTO {
    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;
    @NotNull
    @ApiModelProperty(value = "Tipo do endereço")
    private TipoEndereco tipo;
    @NotEmpty
    @NotBlank
    @Size(max = 250)
    @ApiModelProperty(value = "Endereço")
    private String logradouro;
    @NotNull
    @ApiModelProperty(value = "Numero")
    private Integer numero;
    @ApiModelProperty(value = "Complemento")
    private String complemento;
    @NotEmpty
    @NotBlank
    @Size(max = 8)
    @ApiModelProperty(value = "CEP")
    private String cep;
    @NotBlank
    @NotEmpty
    @Size(max = 250)
    @ApiModelProperty(value = "Cidade")
    private String cidade;
    @NotBlank
    @ApiModelProperty(value = "Estado")
    private String estado;
    @NotBlank
    @ApiModelProperty(value = "Pais")
    private String pais;

}