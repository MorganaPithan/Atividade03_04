package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.BrasilApi;
import br.org.fundatec.lpIII.atividades.model.CepAberto;
import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.model.ViaCep;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String URL_CepAberto = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;
        String token = "0c6eab26e410d157732548165b0cef1c";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=" + token);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        CepAberto cepAberto = restTemplate.getForObject(URL_CepAberto, CepAberto.class, cep);
        try {
            ResponseEntity<CepAberto> response = restTemplate.exchange(URL_CepAberto, HttpMethod.GET, entity, CepAberto.class);
            CepAberto cepAbertoresponse = response.getBody();
            if (cepAbertoresponse != null) {
                return Endereco.builder()
                        .cep("cepAberto")
                        .build();
            }
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
