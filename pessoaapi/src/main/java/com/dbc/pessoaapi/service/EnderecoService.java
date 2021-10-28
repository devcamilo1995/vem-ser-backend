package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
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

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception {
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco endereco) throws Exception {
        return enderecoRepository.update(id, endereco);
    }


    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }
    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }
}