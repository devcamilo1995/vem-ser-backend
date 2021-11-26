package com.vemser.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "reserva")
public class ReservaEntity {
    @Id
    private String id;
    private String usuario;
    private String hotel;
}
