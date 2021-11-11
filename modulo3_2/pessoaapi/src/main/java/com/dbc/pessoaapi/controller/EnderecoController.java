package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;


    @ApiOperation(value = "Lista todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereços listados com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @ApiOperation(value = "Anexa um endereço por ID da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço anexado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                              @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        log.info("Criando endereco");
        EnderecoDTO enderecoDTO = enderecoService.create(idPessoa, enderecoCreateDTO);
        log.info("Endereco criado");
        return enderecoDTO;
    }

    @ApiOperation(value = "Atualiza um endereço por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable("id") @NotNull Integer id,
                              @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        log.info("Atualizar endereco");
        EnderecoDTO enderecoEntityAtt = enderecoService.update(id, enderecoCreateDTO);
        log.info("Endereco atualizado");
        return enderecoEntityAtt;
    }


    @ApiOperation(value = "Deleta um endereço por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço deletado com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        log.info("Deletar endereco");
        enderecoService.delete(id);
        log.info("Endereco deletado");
    }

    @GetMapping("/procurar-endereco-por-pais")
    public List<EnderecoEntity> procurarEnderecoPorPais(@RequestParam String pais) {
        return enderecoRepository.procurarEnderecoPorPais(pais);
    }

    @GetMapping("/procurar-endereco-por-id-pessoa")
    public List<EnderecoEntity> procurarEnderecoPorIdPessoa(@RequestParam("idPessoa") Integer idPessoa) {
        return enderecoRepository.procurarEnderecoPorIdPessoa(idPessoa);
    }

    @GetMapping("/procurar-endereco-por-pais-ou-cidade-nativo")
    public List<EnderecoEntity> getEnderecoByPaisOuCidade(@RequestParam("pS") String paisCidade) {
        return enderecoRepository.getEnderecoByPaisOuCidade(paisCidade);
    }

    @GetMapping("/procurar-endereco-complemento-nulo")
    public List<EnderecoEntity> procurarPessoasComComplementoNull() {
        return enderecoRepository.procurarEnderecoComplementoNull();


    }
}
