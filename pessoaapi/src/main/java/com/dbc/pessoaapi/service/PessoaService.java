package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa create(Pessoa pessoa) throws Exception {
        if (StringUtils.isBlank(pessoa.getNome())) {
            throw new Exception("Nome não encontrado");
        }
        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())) {
            throw new Exception("Data de nascimento obrigatoria");
        }
        if (StringUtils.length(pessoa.getCpf()) != 11) {
            throw new Exception("CPF deve conter 11 digitos");
        }

        return pessoaRepository.create(pessoa);

    }
        public List<Pessoa> list () {
            return pessoaRepository.list();
        }

        public Pessoa update (Integer id,
                Pessoa pessoaAtualizar) throws Exception {
            return pessoaRepository.update(id, pessoaAtualizar);
        }

        public void delete (Integer id) throws Exception {
            pessoaRepository.delete(id);
        }

        public List<Pessoa> listByName (String nome){
            return pessoaRepository.listByName(nome);
        }
    }

