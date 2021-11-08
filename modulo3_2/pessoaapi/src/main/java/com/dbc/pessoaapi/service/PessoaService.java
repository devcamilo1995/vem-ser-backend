package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        PessoaEntity pessoaCriar = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriar, PessoaDTO.class);
        return pessoaDTO;
        }


        public List<PessoaDTO> list () {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                    .collect(Collectors.toList());
        }

        public PessoaDTO update (Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
            findById(id);
            PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
            entity.setIdPessoa(id);
            PessoaEntity update = pessoaRepository.save(entity);
            PessoaDTO dto = objectMapper.convertValue(update, PessoaDTO.class);
            return dto;

        }

        public void delete (Integer id) throws Exception {
            PessoaEntity pessoa = findById(id);
            pessoaRepository.delete(pessoa);
        }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }


        public PessoaEntity findById(Integer id) throws RegraDeNegocioException{
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return entity;
        }
    }
