package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity,Integer> {

    @Query("select c from CONTATO c where c.tipoContato = :tipoContato")
    List<ContatoEntity> procurarContatoPorTipo(TipoContato tipoContato);


    @Query(value = "select * from VEM_SER.CONTATO c where c.id_pessoa = :idPessoa", nativeQuery = true)
    List<ContatoEntity> procurarContatoPorIdPessoa(Integer idPessoa);

}
