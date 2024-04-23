package com.moleniuk.apirastreiossw.controllers;

import com.moleniuk.apirastreiossw.services.RastreioSSWServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RestreioSSWController {

    private final RastreioSSWServices rastreioSSWServices;

    @GetMapping(value = "/cpf/{cpf}", produces = {"application/json"})
    public String rastrear(@PathVariable String cpf) {
        return rastreioSSWServices.rastrear(cpf);
    }

}