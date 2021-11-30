package com.dbc.veiculoprodutorconsumidor.repository;

import dto.CarroDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends MongoRepository <CarroDTO, String> {
}
