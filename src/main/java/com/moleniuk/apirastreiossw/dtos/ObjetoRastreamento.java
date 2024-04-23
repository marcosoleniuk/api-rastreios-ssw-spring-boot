package com.moleniuk.apirastreiossw.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ObjetoRastreamento {
    private String destinatario;
    private String coleta;
    private String notaFiscal;
    private String pedido;
    private List<Rastreamento> rastreamento;

}
