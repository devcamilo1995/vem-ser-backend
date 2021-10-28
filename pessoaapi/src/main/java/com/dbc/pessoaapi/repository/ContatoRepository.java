package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),1, TipoContato.ofTipo(1),"12981117598","wpp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),2, TipoContato.ofTipo(2),"12981117597","wpp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),3, TipoContato.ofTipo(1),"12981117596","wpp"));
    }

    public Contato create(Integer idPessoa, Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }
    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }


    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }
    public List<Contato> listByNumero(String numero) {
        return listaContatos.stream()
                .filter(contato -> contato.getNumero().toUpperCase().contains(numero.toUpperCase()))
                .collect(Collectors.toList());
    }
    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
