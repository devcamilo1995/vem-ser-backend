package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.DadosPessoaisService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
@Slf4j
@RequiredArgsConstructor
public class DadosPessoaisController {
    private final DadosPessoaisService dadosPessoaisService;
    private final DadosPessoaisClient dadosPessoaisClient;

    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PostMapping
    public DadosPessoaisDTO create(@RequestBody @Valid DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        log.info("Criando pessoa");
        DadosPessoaisDTO dadosPessoaisDTOCriar = dadosPessoaisService.create(dadosPessoaisDTO);
        log.info("pessoa criada");
        return dadosPessoaisDTOCriar;
    }
    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping("/dados-pessoais")
    public List<DadosPessoaisDTO> listarDados() {
        return dadosPessoaisClient.listar();
    }

    @DeleteMapping("/cpf")
    public void delete(@RequestParam("cpf")String cpf){dadosPessoaisService.delete(cpf);}

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@RequestParam("cpf")String cpf,@RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception{
        return dadosPessoaisService.update(cpf, dadosPessoaisDTO);
    }
}
