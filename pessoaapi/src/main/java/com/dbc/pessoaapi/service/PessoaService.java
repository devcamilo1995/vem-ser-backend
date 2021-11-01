package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriar = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriar, PessoaDTO.class);
        return pessoaDTO;
        }


        public List<PessoaDTO> list () {
            return pessoaRepository.list().stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }

        public PessoaDTO update (Integer id,
                                    PessoaCreateDTO pessoaCreateDTO) throws Exception {
            PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
            PessoaEntity update = pessoaRepository.update(id, entity);
            PessoaDTO dto = objectMapper.convertValue(update, PessoaDTO.class);
            return dto;

        }

        public void delete (Integer id) throws Exception {
            pessoaRepository.delete(id);
        }

        public List<PessoaDTO> listByName (String nome){
            return pessoaRepository.listByName(nome).stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }
    }

