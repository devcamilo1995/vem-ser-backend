package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
public class ContatoController {
@Autowired
    private ContatoService contatoService;



    @GetMapping
    public List<ContatoEntity> list() {
        return contatoService.list();
    }

    @GetMapping("/bynumero")
    public List<ContatoEntity> listByNumero(@RequestParam("numero") String numero) {
        return contatoService.listByNumero(
                numero);
    }

    @GetMapping("/byidpessoa")
    public List<ContatoEntity> listByIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(
                idPessoa);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletar contato");
        contatoService.delete(id);
        log.info("Contato deletado");
    }

    @PutMapping("/{idContato}")
    public ContatoEntity update(@PathVariable("idContato") @NotNull Integer id,
                                @RequestBody @Valid ContatoEntity contatoEntityAtualizar) throws Exception {
        log.info("Atualizar contato");
        ContatoEntity contatoEntityAtt = contatoService.update(id, contatoEntityAtualizar);
        log.info("Contato atualizado");
        return contatoEntityAtt;
    }


    @PostMapping("/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                                @RequestBody @Valid ContatoEntity contatoEntity) throws Exception {
        log.info("Criando contato");
        ContatoEntity contatoEntityCriar = contatoService.create(idPessoa, contatoEntity);
        log.info("Contato criado");
        return contatoEntityCriar;

    }







}
