package com.moleniuk.apirastreiossw.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moleniuk.apirastreiossw.dtos.ObjetoRastreamento;
import com.moleniuk.apirastreiossw.dtos.Rastreamento;
import com.moleniuk.apirastreiossw.usecase.ExtrairURLFromOnclick;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RastreioSSWServices {

    private final ObjectMapper objectMapper;
    private final ExtrairURLFromOnclick extrairURLFromOnclick;

    @Cacheable("rastreioCache")
    public String rastrear(String cpf) {
        var urlFull = "https://ssw.inf.br";
        String url = urlFull + "/2/resultSSW_dest?cnpjdest=" + cpf;
        try {
            Document doc = Jsoup.connect(url).get();
            Element link = doc.selectFirst("a.email");
            if (link == null) {
                return "{\"message\": \"Nenhuma informação encontrada para o CPF fornecido.\"}";
            }

            String onclickValue = link.attr("onclick");
            String urlDetalhado = extrairURLFromOnclick.execute(onclickValue);

            Document docDetalhado = Jsoup.connect(urlFull + urlDetalhado).get();

            ObjetoRastreamento objetoRastreamento = extrairDadosRastreamento(docDetalhado);
            return objectMapper.writeValueAsString(objetoRastreamento);

        } catch (IOException e) {
            return "{\"message\": \"Erro ao tentar acessar a página.\"}";
        }
    }

    private ObjetoRastreamento extrairDadosRastreamento(Document docDetalhado) {
        String destinatario = Objects.requireNonNull(Objects.requireNonNull(docDetalhado.select("td:contains(Destinatário)").first()).nextElementSibling()).text();
        Elements linhasRastreamento = docDetalhado.select("tr[class^=background]");
        List<Rastreamento> rastreamentoList = new ArrayList<>();
        for (Element linha : linhasRastreamento) {
            String dataHora = linha.select("td").get(0).select("p").text().replace("<br>", " ");
            String localUnidade = linha.select("td").get(1).select("p").text().replace("<br>", " ");
            String situacao = linha.select("td").get(2).select("p").text();

            Rastreamento rastreamento = new Rastreamento(dataHora, localUnidade, situacao);
            rastreamentoList.add(rastreamento);
        }

        Elements rows = Objects.requireNonNull(docDetalhado.select("table").first()).select("tr");
        String nColeta = rows.get(3).select("td").get(1).text().trim();
        String nNotaFiscal = rows.get(3).select("td").get(3).text().trim();
        String nPedido = rows.get(3).select("td").get(5).text().trim();

        ObjetoRastreamento objetoRastreamento = new ObjetoRastreamento();
        objetoRastreamento.setDestinatario(destinatario.isEmpty() ? null : destinatario);
        objetoRastreamento.setColeta(nColeta.isEmpty() ? null : nColeta);
        objetoRastreamento.setNotaFiscal(nNotaFiscal.isEmpty() ? null : nNotaFiscal);
        objetoRastreamento.setPedido(nPedido.isEmpty() ? null : nPedido);
        objetoRastreamento.setRastreamento(rastreamentoList);

        return objetoRastreamento;
    }
}
