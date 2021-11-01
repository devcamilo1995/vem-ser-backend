package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoEntity> list() {
        return enderecoService.list();
    }

    @GetMapping("/idendereco")
    public List<EnderecoEntity> listByIdEndereco(@RequestParam("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(
                idEndereco);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoEntity create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                                 @RequestBody @Valid EnderecoEntity enderecoEntity) throws Exception {
        log.info("Criando endereco");
        EnderecoEntity enderecoEntityCriar = enderecoService.create(idPessoa, enderecoEntity);
        log.info("Endereco criado");
        return enderecoEntityCriar;
    }
    @PutMapping("/{id}")
    public EnderecoEntity update(@PathVariable("id") @NotNull Integer id,
                                 @RequestBody @Valid EnderecoEntity enderecoEntity) throws Exception {
        log.info("Atualizar endereco");
        EnderecoEntity enderecoEntityAtt = enderecoService.update(id, enderecoEntity);
        log.info("Endereco atualizado");
        return enderecoEntityAtt;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deletar endereco");
        enderecoService.delete(id);
        log.info("Endereco deletado");
    }




}
