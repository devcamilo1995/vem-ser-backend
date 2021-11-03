package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<ContatoEntity> listaContatoEntities = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet(),1, TipoContato.ofTipo(1),"12981117598","wpp"));
        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet(),2, TipoContato.ofTipo(2),"12981117597","wpp"));
        listaContatoEntities.add(new ContatoEntity(COUNTER.incrementAndGet(),3, TipoContato.ofTipo(1),"12981117596","wpp"));
    }

    public ContatoEntity create(ContatoEntity contatoEntity) throws RegraDeNegocioException {

        contatoEntity.setIdContato(COUNTER.incrementAndGet());
        listaContatoEntities.add(contatoEntity);
        return contatoEntity;

    }
    public List<ContatoEntity> list() {
        return listaContatoEntities;
    }

    public ContatoEntity update(Integer id,
                                ContatoEntity contatoEntityAtualizar) throws Exception {
        ContatoEntity contatoEntityRecuperado = listaContatoEntities.stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contatoEntityRecuperado.setTipoContato(contatoEntityAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoEntityAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoEntityAtualizar.getDescricao());
        return contatoEntityRecuperado;
    }


    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = listaContatoEntities.stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        listaContatoEntities.remove(contatoEntityRecuperado);
    }
    public List<ContatoEntity> listByNumero(String numero) {
        return listaContatoEntities.stream()
                .filter(contatoEntity -> contatoEntity.getNumero().toUpperCase().contains(numero.toUpperCase()))
                .collect(Collectors.toList());
    }
    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) {
        return listaContatoEntities.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
