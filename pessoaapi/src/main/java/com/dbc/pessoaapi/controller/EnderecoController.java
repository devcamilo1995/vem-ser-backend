package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/idendereco")
    public List<Endereco> listByIdEndereco(@RequestParam("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(
                idEndereco);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                          @RequestBody @Valid Endereco endereco) throws Exception {
        return enderecoService.create(idPessoa, endereco);
    }
    @PutMapping("/{id}")
    public Endereco update(@PathVariable("id") @NotNull Integer id,
                          @RequestBody @Valid Endereco endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        enderecoService.delete(id);
    }




}
