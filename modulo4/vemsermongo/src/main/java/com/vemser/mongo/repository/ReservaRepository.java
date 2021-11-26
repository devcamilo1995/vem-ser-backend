package com.vemser.mongo.repository;

import com.vemser.mongo.entity.ReservaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends MongoRepository <ReservaEntity, String>{
}
