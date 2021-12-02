package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class PessoaContatoDTO {
    private Integer idPessoa;
    @NotEmpty
    @NotBlank
    @ApiModelProperty(value= "Nome da Pessoa")
    private String nome;
    @NotNull
    @Past
    @ApiModelProperty(value= "Data de nascimento")
    private LocalDate dataNascimento;
    @NotEmpty
    @NotBlank
    @Size(max = 11, min = 11)
    @ApiModelProperty(value= "CPF")
    private String cpf;
    @ApiModelProperty(value= "E-mail")
    private String email;
    private List <ContatoDTO> contatoDTOList;
}
