package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.CepAbertoDTO;
import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Slf4j
public class CepAbertoRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoDTO searchByCep(String cep) {

        String URL_CepAberto = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token token=0c6eab26e410d157732548165b0cef1c");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<CepAbertoDTO> response = restTemplate.exchange(URL_CepAberto, HttpMethod.GET, entity, CepAbertoDTO.class);
            CepAbertoDTO cepAbertoresponse = response.getBody();
            if (cepAbertoresponse != null) {
                return EnderecoDTO.builder()
                        .api("CepAberto")
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


