package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);

    @Query("select p from PESSOA p join p.enderecos e")
    List<PessoaEntity> procurarPessoasComEndereco();

    @Query("SELECT p FROM PESSOA p where p.dataNascimento BETWEEN :inicio AND :fim")
            List<PessoaEntity> procurarPessoasPorDataNascimento (LocalDate inicio, LocalDate fim);


    @Query(value = "select * " +
            "from VEM_SER.PESSOA p " +
            "LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe ON (p.id_pessoa = pxpe.id_pessoa) where pxpe.id_pessoa IS NULL", nativeQuery = true)
    List<PessoaEntity> procurarPessoasComEnderecoNull();





}
