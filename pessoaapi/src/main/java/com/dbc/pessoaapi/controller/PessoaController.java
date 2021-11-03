package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;


    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaDTO) throws Exception {
        log.info("Criando pessoa");
        PessoaDTO pessoaEntityCriar = pessoaService.create(pessoaDTO);
        log.info("pessoa criada");
        return pessoaEntityCriar;
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiOperation(value = "Retorna uma lista de pessoas por nome")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Atualiza uma pessoa pelo ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                               @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Atualizar pessoa");
        PessoaDTO pessoaEntityAtt = pessoaService.update(id, pessoaCreateDTO);
        log.info("Pessoa atualizada");
        return pessoaEntityAtt;
    }

    @ApiOperation(value = "Deleta uma pessoa pelo ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa deletada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") @NotNull Integer id) throws Exception {
        log.info("Deletando pessoa");
        pessoaService.delete(id);
        log.info("Pessoa deletada");
    }
}
