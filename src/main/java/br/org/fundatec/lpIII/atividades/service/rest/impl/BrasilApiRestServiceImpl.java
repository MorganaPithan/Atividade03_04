package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.BrasilApi;
import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;
public class BrasilApiRestServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String URL_BrasilApi = "https://brasilapi.com.br/api/cep/v1/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        BrasilApi brasilApi = restTemplate.getForObject(URL_BrasilApi, BrasilApi.class, cep);
        if (brasilApi != null) {
            return Endereco.builder()
                    .cep("BrasilApi")
                    .estado(brasilApi.getState())
                    .cidade(brasilApi.getCity())
                    .bairro(brasilApi.getNeighborhood())
                    .logradouro(brasilApi.getStreet())
                    .build();
        }
        return null;
    }
}
