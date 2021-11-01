package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }

    public EnderecoEntity create(Integer idPessoa, EnderecoEntity enderecoEntity) throws Exception {
        PessoaEntity pessoaEntity = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrado"));
        enderecoEntity.setIdPessoa(pessoaEntity.getIdPessoa());
        return enderecoRepository.create(enderecoEntity);
    }

    public EnderecoEntity update(Integer id, EnderecoEntity enderecoEntity) throws Exception {
        return enderecoRepository.update(id, enderecoEntity);
    }


    public List<EnderecoEntity> list() {
        return enderecoRepository.list();
    }

    public List<EnderecoEntity> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }
    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }
}