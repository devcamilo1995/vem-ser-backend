package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoEndereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> enderecoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.ofTipo(1),"um",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.ofTipo(1),"dois",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),3, TipoEndereco.ofTipo(1),"tres",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
}


    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }
    public Endereco update(Integer id, Endereco endereco) throws Exception {
        Endereco enderecoAlterado = enderecoList.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrado"));
        enderecoAlterado.setTipo(endereco.getTipo());
        enderecoAlterado.setLogradouro(endereco.getLogradouro());
        enderecoAlterado.setNumero(endereco.getNumero());
        enderecoAlterado.setComplemento(endereco.getComplemento());
        enderecoAlterado.setCep(endereco.getCep());
        enderecoAlterado.setCep(endereco.getCidade());
        enderecoAlterado.setEstado(endereco.getEstado());
        enderecoAlterado.setPais(endereco.getPais());
        return enderecoAlterado;
    }

    public List<Endereco> list() {
        return enderecoList;
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco)  {
        return enderecoList.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }
    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
    public void delete(Integer id) throws Exception {
        Endereco endereco = enderecoList.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        enderecoList.remove(endereco);
    }
}
