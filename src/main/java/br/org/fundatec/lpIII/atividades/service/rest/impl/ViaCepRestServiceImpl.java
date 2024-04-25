package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Endereco;
import br.org.fundatec.lpIII.atividades.model.ViaCep;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;

public class ViaCepRestServiceImpl implements ExternalCepRestService {
    @Override
    public Endereco searchByCep(String cep) {
        String URL_ViaCep = "https://viacep.com.br/ws/" + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        ViaCep viaCep = restTemplate.getForObject(URL_ViaCep, ViaCep.class, cep);
        if (viaCep != null) {
            return Endereco.builder()
                    .cep("ViaCep")
                    .logradouro(viaCep.getLogradouro())
                    .bairro(viaCep.getBairro())
                    .cidade(viaCep.getLocalidade())
                    .estado(viaCep.getUf())
                    .build();
        }
        return null;
    }
}
