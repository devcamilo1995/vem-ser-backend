package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;


    @GetMapping("/lista-ordenada-contato")
    public Page<ContatoEntity> listaOrdernadaContato(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina,
                Sort.by("descricao"));
        Page<ContatoEntity> contato = contatoRepository.findAll(pageable);
        return contato;
    }
    @GetMapping("/lista-ordenada-cep")
    public Page<EnderecoEntity> listaOrdernadaCep(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina,
                Sort.by("cep"));
        Page<EnderecoEntity> endereco = enderecoRepository.findAll(pageable);
        return endereco;
    }
    @GetMapping("/lista-filter-pais")
    public Page<EnderecoEntity> listaOrdernadaCepPais(
            @RequestParam String pais,
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina){
        Pageable pageable = PageRequest.of(pagina,
                quantidadeDeRegistrosPorPagina);
        Page<EnderecoEntity> endereco = enderecoRepository.procurarEnderecoPorPaisJPQL(pais,pageable);
        return endereco;
    }

}

