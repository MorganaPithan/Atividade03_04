package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.CepAberto;
import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Slf4j
public class CepAbertoServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {

        String URL_CepAberto = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=0c6eab26e410d157732548165b0cef1c");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<CepAberto> response = restTemplate.exchange(URL_CepAberto, HttpMethod.GET, entity, CepAberto.class);
            CepAberto cepAbertoresponse = response.getBody();
            if (cepAbertoresponse != null) {
                return Endereco.builder()
                        .cidade(cepAbertoresponse.getCidade().getNome())
                        .estado(cepAbertoresponse.getEstado().getSigla())
                        .bairro(cepAbertoresponse.getBairro())
                        .cep(cepAbertoresponse.getCep())
                        .logradouro(cepAbertoresponse.getLogradouro())
                        .build();
            }
        } catch (HttpClientErrorException e) {
            log.error( e.getMessage());
        }

        return null;
    }
}


