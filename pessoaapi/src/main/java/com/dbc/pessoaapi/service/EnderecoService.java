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
        enderecoRepository.delete(id);
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoCriarEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        PessoaEntity pessoaEntity = pessoaRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        enderecoCriarEntity.setIdPessoa(id);
        EnderecoEntity enderecoCriar = enderecoRepository.create(enderecoCriarEntity);
        EnderecoDTO dto = objectMapper.convertValue(enderecoCriar, EnderecoDTO.class);
        return dto;
    }


    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws Exception{
        EnderecoEntity enderecoAtualizarEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity enderecoAtualizar = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        EnderecoEntity update = enderecoRepository.update(idEndereco, enderecoAtualizarEntity);
        EnderecoDTO dto = objectMapper.convertValue(update, EnderecoDTO.class);
        return dto;
    }


    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream().map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
}