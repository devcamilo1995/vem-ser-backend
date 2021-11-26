package com.vemser.mongo.service;

import com.vemser.mongo.entity.ReservaEntity;
import com.vemser.mongo.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaEntity save (ReservaEntity reservaEntity) {
        return reservaRepository.save(reservaEntity);
    }

    public List<ReservaEntity> findAll() {
        return reservaRepository.findAll();
    }

    public long count() {
        return reservaRepository.count();
    }

//    public ReservaEntity findById(String id) {
//        return reservaRepository.findOne(id);
//    }
//
//    public void delete(String id) {
//        reservaRepository.delete(id);
    }

//}

