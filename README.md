# API de Rastreamento de Encomendas SSW - Spring Boot

![GitHub](https://img.shields.io/github/license/marcosoleniuk/api-rastreios-ssw-spring-boot)
![GitHub last commit](https://img.shields.io/github/last-commit/marcosoleniuk/api-rastreios-ssw-spring-boot)
![GitHub repo size](https://img.shields.io/github/repo-size/marcosoleniuk/api-rastreios-ssw-spring-boot)

API para rastreamento de encomendas do site ssw.inf.br. Esta API é desenvolvida em Spring Boot e permite que os usuários rastreiem suas encomendas de forma rápida e eficiente.

## Como Usar

Para utilizar a API, você precisa acessar o seguinte endpoint:

GET https://api.moleniuk.com/api/v1/cpf/seu_cpf

Certifique-se de substituir `seu_cpf` pelo seu CPF válido. Este endpoint retornará os detalhes de rastreamento das suas encomendas associadas ao seu CPF.

## Exemplo de Resposta

Aqui está um exemplo de resposta da API:

```json
{
  "destinatario": "Marcos *******",
  "coleta": null,
  "notaFiscal": "1 0000000",
  "pedido": "000000",
  "rastreamento": [
    {
      "dataHora": "19/04/24 02:45",
      "localUnidade": "ITAJAI / SC RED ITJ",
      "situacao": "DOCUMENTO DE TRANSPORTE EMITIDO CT-e autorizado com 1 volume e 0 Kg. Destino: PR/ARARUNA. Previsao de entrega: 24/04/24."
    },
    {
      "dataHora": "19/04/24 21:29",
      "localUnidade": "ITAJAI / SC RED ITJ",
      "situacao": "SAIDA DE UNIDADE Saida da unidade ITAJAI em 19/04/24, 21:29h. Previsao de chegada na unidade SAO JOSE DOS PINHAIS em 20/04/24, 01:29h."
    },
    {
      "dataHora": "20/04/24 13:08",
      "localUnidade": "SAO JOSE DOS PINHAIS / PR RED CUR",
      "situacao": "CHEGADA EM UNIDADE Chegada na unidade SAO JOSE DOS PINHAIS em 20/04/24, 13:08h."
    },
    {
      "dataHora": "21/04/24 17:14",
      "localUnidade": "SAO JOSE DOS PINHAIS / PR RED CUR",
      "situacao": "SAIDA DE UNIDADE Saida da unidade SAO JOSE DOS PINHAIS em 21/04/24, 17:14h. Previsao de chegada na unidade MARINGA em 22/04/24, 01:14h."
    },
    {
      "dataHora": "22/04/24 11:27",
      "localUnidade": "MARINGA / PR RED MGF",
      "situacao": "CHEGADA EM UNIDADE Chegada na unidade MARINGA em 22/04/24, 11:27h."
    }
  ]
}
```

Contribuindo
Se você deseja contribuir para este projeto, por favor siga os passos abaixo:

Faça um fork do repositório
Crie uma branch para sua feature (git checkout -b feature/MinhaFeature)
Faça commit das suas alterações (git commit -am 'Adicionando nova feature')
Faça push para a branch (git push origin feature/MinhaFeature)
Crie um novo Pull Request
Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
