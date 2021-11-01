package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<EnderecoEntity> enderecoEntityList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        enderecoEntityList.add(new EnderecoEntity(COUNTER.incrementAndGet(),1, TipoEndereco.ofTipo(1),"um",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
        enderecoEntityList.add(new EnderecoEntity(COUNTER.incrementAndGet(),2, TipoEndereco.ofTipo(1),"dois",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
        enderecoEntityList.add(new EnderecoEntity(COUNTER.incrementAndGet(),3, TipoEndereco.ofTipo(1),"tres",484,"Não tem","12504-010","Guaratingueta","São Paulo","Brasil"));
}


    public EnderecoEntity create(EnderecoEntity enderecoEntity) {
        enderecoEntity.setIdEndereco(COUNTER.incrementAndGet());
        enderecoEntityList.add(enderecoEntity);
        return enderecoEntity;
    }
    public EnderecoEntity update(Integer id, EnderecoEntity enderecoEntity) throws Exception {
        EnderecoEntity enderecoEntityAlterado = enderecoEntityList.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrado"));
        enderecoEntityAlterado.setTipo(enderecoEntity.getTipo());
        enderecoEntityAlterado.setLogradouro(enderecoEntity.getLogradouro());
        enderecoEntityAlterado.setNumero(enderecoEntity.getNumero());
        enderecoEntityAlterado.setComplemento(enderecoEntity.getComplemento());
        enderecoEntityAlterado.setCep(enderecoEntity.getCep());
        enderecoEntityAlterado.setCep(enderecoEntity.getCidade());
        enderecoEntityAlterado.setEstado(enderecoEntity.getEstado());
        enderecoEntityAlterado.setPais(enderecoEntity.getPais());
        return enderecoEntityAlterado;
    }

    public List<EnderecoEntity> list() {
        return enderecoEntityList;
    }

    public List<EnderecoEntity> listByIdEndereco(Integer idEndereco)  {
        return enderecoEntityList.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }
    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
        return enderecoEntityList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
    public void delete(Integer id) throws Exception {
        EnderecoEntity enderecoEntity = enderecoEntityList.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        enderecoEntityList.remove(enderecoEntity);
    }
}
