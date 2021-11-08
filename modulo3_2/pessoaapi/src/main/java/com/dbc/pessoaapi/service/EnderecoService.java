package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;

    public void delete(Integer id) throws Exception {
        EnderecoEntity endereco = findById(id);
        enderecoRepository.delete(endereco);
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoCriar = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriar, EnderecoDTO.class);
        return enderecoDTO;
    }


    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException{
        EnderecoEntity enderecoAtualizarEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoAtualizarEntity.setIdEndereco(id);
        EnderecoEntity update = enderecoRepository.save(enderecoAtualizarEntity);
        EnderecoDTO dto = objectMapper.convertValue(update, EnderecoDTO.class);
        return dto;
    }


    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }


    public EnderecoEntity findById(Integer id) throws RegraDeNegocioException{
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrada"));
        return entity;
    }
}