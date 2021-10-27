package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService(){contatoRepository = new ContatoRepository();}

    public Contato create(Integer idPessoa, Contato contato){return contatoRepository.create(idPessoa,contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();

    }
    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete (Integer id) throws Exception {
            contatoRepository.delete(id);
        }
    public List<Contato> listByNumero(String numero) {
        return contatoRepository.listByNumero(numero);
    }

//    public List<Contato> listByIdPessoa(Integer idPessoa) {
//        return contatoRepository.listByIdPessoa(idPessoa);
//    }
}


