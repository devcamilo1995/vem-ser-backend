package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
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
@RequestMapping("/contato")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @ApiOperation(value = "Lista todos os contatos")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "contatos listados com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @ApiOperation(value = "Lista todos os contatos por ID pessoa")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "contatos listados com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping("/byidpessoa")
    public List<ContatoDTO> listByIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(
                idPessoa);
    }
    @ApiOperation(value = "Deleta um contato por ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "contatos deletado com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletar contato");
        contatoService.delete(id);
        log.info("Contato deletado");
    }

    @ApiOperation(value = "Atualiza um contato pelo ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "contatos atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PutMapping("/{idContato}")
    public ContatoDTO update(@PathVariable("idContato") @NotNull Integer id,
                             @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.info("Atualizar contato");
        ContatoDTO contatoEntityAtt = contatoService.update(id, contatoCreateDTO);
        log.info("Contato atualizado");
        return contatoEntityAtt;
    }

    @ApiOperation(value = "Cria um contato pelo ID da Pessoa")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "contato criado com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                                @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.info("Criando contato");
        ContatoDTO contatoEntityCriar = contatoService.create(idPessoa, contatoCreateDTO);
        log.info("Contato criado");
        return contatoEntityCriar;

    }







}
