package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.PessoaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @GetMapping
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname")
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }


    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa")  @NotNull Integer id,
                         @RequestBody @Valid Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
