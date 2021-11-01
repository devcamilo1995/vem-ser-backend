package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.PessoaService;
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


    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaDTO) throws Exception {
        log.info("Criando pessoa");
        PessoaDTO pessoaEntityCriar = pessoaService.create(pessoaDTO);
        log.info("pessoa criada");
        return pessoaEntityCriar;
    }

    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                               @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Atualizar pessoa");
        PessoaDTO pessoaEntityAtt = pessoaService.update(id, pessoaCreateDTO);
        log.info("Pessoa atualizada");
        return pessoaEntityAtt;
    }


    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") @NotNull Integer id) throws Exception {
        log.info("Deletando pessoa");
        pessoaService.delete(id);
        log.info("Pessoa deletada");
    }
}
