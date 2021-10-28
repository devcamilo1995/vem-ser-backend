package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
@Autowired
    private ContatoService contatoService;



    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/bynumero")
    public List<Contato> listByNumero(@RequestParam("numero") String numero) {
        return contatoService.listByNumero(
                numero);
    }

    @GetMapping("/byidpessoa")
    public List<Contato> listByIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(
                idPessoa);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") @NotNull Integer id,
                         @RequestBody @Valid Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }


    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                          @RequestBody @Valid Contato contato) throws Exception {
        return contatoService.create(idPessoa, contato);

    }







}
