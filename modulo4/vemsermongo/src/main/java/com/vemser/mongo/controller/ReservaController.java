package com.vemser.mongo.controller;


import com.vemser.mongo.entity.ReservaEntity;
import com.vemser.mongo.service.ReservaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
@Slf4j
public class ReservaController {
    private final ReservaService reservaService;

    @GetMapping
    public List<ReservaEntity> list(){
        return reservaService.findAll();
    }


    @PostMapping
    public ReservaEntity save(@RequestBody ReservaEntity reservaEntity){
        return reservaService.save(reservaEntity);
    }
}
