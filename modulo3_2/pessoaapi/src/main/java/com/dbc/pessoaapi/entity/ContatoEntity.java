package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQUENCIA")
    @SequenceGenerator(name = "CONTATO_SEQUENCIA",sequenceName = "seq_contato",allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;
    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;

}
