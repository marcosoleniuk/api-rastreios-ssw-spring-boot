package com.moleniuk.apirastreiossw.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResultadoRastreamento {
        private String nfColeta;
        private String unidadeDataHora;
        private String situacao;
}


