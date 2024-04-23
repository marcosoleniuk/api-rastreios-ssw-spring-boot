package com.moleniuk.apirastreiossw.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rastreamento {
    private String dataHora;
    private String localUnidade;
    private String situacao;
}
