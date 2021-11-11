package com.dbc.pessoaapi.repository;


import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

    @Query("select ep from ENDERECO_PESSOA ep where ep.pais = :pais")
    List<EnderecoEntity> procurarEnderecoPorPais(String pais);


    @Query("select ep from ENDERECO_PESSOA ep join ep.pessoa p where p.idPessoa = :idPessoa")
    List<EnderecoEntity> procurarEnderecoPorIdPessoa(Integer idPessoa);

    @Query(value= "select * from VEM_SER.ENDERECO_PESSOA ep where ep.pais = ?1 OR ep.cidade = ?1", nativeQuery = true)
    List<EnderecoEntity> getEnderecoByPaisOuCidade(String paisCidade);

    @Query(value = "select * from VEM_SER.ENDERECO_PESSOA ep WHERE COMPLEMENTO IS NULL", nativeQuery = true)
    List<EnderecoEntity> procurarEnderecoComplementoNull();





}
