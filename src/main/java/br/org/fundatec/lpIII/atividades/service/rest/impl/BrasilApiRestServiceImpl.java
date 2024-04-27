package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.BrasilApiDTO;
import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;
public class BrasilApiRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoDTO searchByCep(String cep) {
        String URL_BrasilApi = "https://brasilapi.com.br/api/cep/v1/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        BrasilApiDTO brasilApi = restTemplate.getForObject(URL_BrasilApi, BrasilApiDTO.class, cep);
        if (brasilApi != null) {
            return EnderecoDTO.builder()
                    .api("BrasilApi")
                    .cep(brasilApi.getCep())
                    .estado(brasilApi.getState())
                    .cidade(brasilApi.getCity())
                    .bairro(brasilApi.getNeighborhood())
                    .logradouro(brasilApi.getStreet())
                    .build();
        }
        return null;
    }
}
