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


    public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoCriarEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        PessoaEntity pessoaEntity = pessoaRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        contatoCriarEntity.setIdPessoa(id);
        ContatoEntity contatoCriar = contatoRepository.create(contatoCriarEntity);
        ContatoDTO dto = objectMapper.convertValue(contatoCriar, ContatoDTO.class);
        return dto;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list().stream().map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());

    }
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws Exception {
        ContatoEntity entity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        ContatoEntity contatoAtualizarEntity = contatoRepository.update(id, entity);
        ContatoDTO dto = objectMapper.convertValue(contatoAtualizarEntity, ContatoDTO.class);
        return dto;
    }

    public void delete (Integer id) throws Exception {
            contatoRepository.delete(id);
        }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}


