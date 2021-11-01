package com.dbc.pessoaapi.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaDTO {
    private Integer idPessoa;
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotEmpty
    @NotBlank
    @Size(max = 11, min = 11)
    private String cpf;

}
