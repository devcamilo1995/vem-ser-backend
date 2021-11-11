package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contato")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoRepository contatoRepository;

    @ApiOperation(value = "Lista todos os contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contatos listados com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @ApiOperation(value = "Deleta um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato deletado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletar contato");
        contatoService.delete(id);
        log.info("Contato deletado");
    }

    @ApiOperation(value = "Atualiza um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contato criado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") @NotNull Integer idPessoa,
                             @RequestBody @Valid ContatoCreateDTO contatoCreateDTO) throws Exception {
        log.info("Criando contato");
        ContatoDTO contatoEntityCriar = contatoService.create(idPessoa, contatoCreateDTO);
        log.info("Contato criado");
        return contatoEntityCriar;

    }

    @GetMapping("/procurar-contato-por-tipo")
    public List<ContatoEntity> procurarContatoPorTipo(@RequestParam TipoContato tipoContato) {
        return contatoRepository.procurarContatoPorTipo(tipoContato);
    }

    @GetMapping("/procurar-contatos-por-id-pessoa")
    public List<ContatoEntity> procurarContatoPorIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoRepository.procurarContatoPorIdPessoa(idPessoa);


    }
}
