package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;


    public ContatoEntity create(Integer idPessoa, ContatoEntity contatoEntity) throws RegraDeNegocioException {return contatoRepository.create(idPessoa, contatoEntity);
    }

    public List<ContatoEntity> list(){
        return contatoRepository.list();

    }
    public ContatoEntity update(Integer id,
                                ContatoEntity contatoEntityAtualizar) throws Exception {
        return contatoRepository.update(id, contatoEntityAtualizar);
    }

    public void delete (Integer id) throws Exception {
            contatoRepository.delete(id);
        }
    public List<ContatoEntity> listByNumero(String numero) {
        return contatoRepository.listByNumero(numero);
    }

    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }
}


