package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {
    private final DadosPessoaisClient dadosPessoaisClient;
    private final ObjectMapper objectMapper;


    public List<DadosPessoaisDTO> list() {
        return dadosPessoaisClient.listar();
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        dadosPessoaisClient.post(dadosPessoaisDTO);
        return dadosPessoaisDTO;
    }
    public void delete(String cpf){
        dadosPessoaisClient.delete(cpf);
    }
    public DadosPessoaisDTO update (String cpf,DadosPessoaisDTO dadosPessoaisDTO) throws  Exception{
        dadosPessoaisClient.update(cpf,dadosPessoaisDTO);
        return dadosPessoaisDTO;

    }
}


