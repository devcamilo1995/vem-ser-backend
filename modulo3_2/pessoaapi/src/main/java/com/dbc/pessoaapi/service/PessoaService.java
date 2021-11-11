package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriar = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriar, PessoaDTO.class);
        return pessoaDTO;
    }


    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(entity);
        PessoaDTO dto = objectMapper.convertValue(update, PessoaDTO.class);
        return dto;

    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }


    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return entity;
    }

    public List<PessoaContatoDTO> listWithContato(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaContatoDTO> listContatoDTO = new ArrayList<>();
        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(pessoa, PessoaContatoDTO.class);
                        pessoaContatoDTO.setContatoDTOList(pessoa.getContatos().stream()
                                .map(contato -> {
                                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                                    return contatoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaContatoDTO;
                    })
                    .collect(Collectors.toList());
        }
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
        PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(pessoaEntity,PessoaContatoDTO.class);
        pessoaContatoDTO.setContatoDTOList(pessoaEntity.getContatos().stream()
                .map(contato -> {
                    ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
                    contatoDTO.setIdPessoa(idPessoa);
                    return contatoDTO;
                })
                .collect(Collectors.toList()));
        listContatoDTO.add(pessoaContatoDTO);
        return listContatoDTO;
    }



        public List<PessoaEnderecoDTO> listWithEndereco(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaEnderecoDTO>listPessoaDTO = new ArrayList<>();
        if (idPessoa == null) {
            return pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoa, PessoaEnderecoDTO.class);
                        pessoaEnderecoDTO.setEnderecoDTOList(pessoa.getEnderecos().stream()
                                .map(endereco -> {
                                    EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                                    return enderecoDTO;
                                })
                                .collect(Collectors.toList()));
                        return pessoaEnderecoDTO;
                    })

                    .collect(Collectors.toList());
        }
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).orElseThrow(()-> new RegraDeNegocioException("Pessoa não encontrada"));
        PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoaEntity,PessoaEnderecoDTO.class);
        pessoaEnderecoDTO.setEnderecoDTOList(pessoaEntity.getEnderecos().stream()
                .map(endereco -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(idPessoa);
                    return enderecoDTO;
                })
                .collect(Collectors.toList()));
        listPessoaDTO.add(pessoaEnderecoDTO);
        return listPessoaDTO;
    }
}








