package com.moleniuk.apirastreiossw.controllers;

import com.moleniuk.apirastreiossw.services.RastreioSSWServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> rastrear(@PathVariable String cpf) {
        if (cpf == null || cpf.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"CPF não informado.\"}");
        return ResponseEntity.ok(rastreioSSWServices.rastrear(cpf));
    }

    @GetMapping(value = "/cpf", produces = {"application/json"})
    public ResponseEntity<String> cpfNaoInformado() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"CPF não informado.\"}");
    }

}