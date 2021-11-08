package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;


    public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreateDTO) throws Exception {
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        PessoaEntity pessoaEntity = pessoaRepository.findById(id).stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        contatoEntity.setIdPessoa(id);
        ContatoEntity contatoCriar = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO= objectMapper.convertValue(contatoCriar, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());

    }
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        entity.setIdContato(id);
        ContatoEntity contatoAtualizarEntity = contatoRepository.save(entity);
        ContatoDTO dto = objectMapper.convertValue(contatoAtualizarEntity, ContatoDTO.class);
        return dto;
    }

    public void delete (Integer id) throws Exception {
        ContatoDTO contato = findById(id);
        ContatoEntity entity = objectMapper.convertValue(contato,ContatoEntity.class);
            contatoRepository.delete(entity);
        }

    public ContatoDTO findById(Integer id) throws RegraDeNegocioException{
        ContatoEntity entity = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        ContatoDTO contatoDTO = objectMapper.convertValue(entity,ContatoDTO.class);
        return contatoDTO;
    }
    }



