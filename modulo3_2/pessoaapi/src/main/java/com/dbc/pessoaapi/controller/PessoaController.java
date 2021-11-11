package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaContatoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaEnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @ApiOperation(value = "Cria uma pessoa")
    @ApiResponses(value = {
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @ApiOperation(value = "Atualiza uma pessoa pelo ID")
    @ApiResponses(value = {
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
    @ApiResponses(value = {
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

    @GetMapping("/find-by-nome-containing-ignorecase")
    public List<PessoaEntity> findByNomeContainingIgnoreCase(@RequestParam String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/find-by-cpf")
    public List<PessoaEntity> findByCpf(@RequestParam String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/find-by-data-nascimento")
    public List< PessoaEntity> findByDataNascimentoBetween(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,

                                                    @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){

        return pessoaRepository.findByDataNascimentoBetween(inicio, fim);
    }


    @GetMapping("/list-with-contato")
    public List<PessoaContatoDTO> ListWithContato (){
        return pessoaService.listWithContato();
    }

    @GetMapping("/list-with-endereco")
    public List<PessoaEnderecoDTO> ListWithEndereco (){
        return pessoaService.listWithEndereco();
    }
    @GetMapping("/procurar-pessoas-com-endereco")
    public List<PessoaEntity> procurarPessoasComEndereco (){
        return pessoaRepository.procurarPessoasComEndereco();
    }
    @GetMapping("/find-pessoa-by-data-nascimento")
    public List< PessoaEntity> procurarPessoasPorDataNascimento(@RequestParam ("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,

                                                           @RequestParam ("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){

        return pessoaRepository.procurarPessoasPorDataNascimento(inicio, fim);
    }

    @GetMapping("/procurar-pessoas-endereco-nulo")
    public List<PessoaEntity> procurarPessoasComEnderecoNulo() {
        return pessoaRepository.procurarPessoasComEnderecoNull();


    }
}


