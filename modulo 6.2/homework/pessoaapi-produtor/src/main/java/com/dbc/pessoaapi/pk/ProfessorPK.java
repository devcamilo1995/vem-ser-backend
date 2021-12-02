package com.dbc.pessoaapi.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorPK  implements Serializable {
    @Column(name= "id_professor")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQUENCIA")
    @SequenceGenerator(name = "PESSOA_SEQUENCIA", sequenceName = "seq_pessoa2",allocationSize = 1)
    private Integer idProfessor;

    @Column(name ="id_universidade")
    private Integer idUniversidade;
}
