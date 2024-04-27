package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;
import br.org.fundatec.lpIII.atividades.model.ViaCepDTO;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import org.springframework.web.client.RestTemplate;

public class ViaCepRestServiceImpl implements ExternalCepRestService {
    @Override
    public EnderecoDTO searchByCep(String cep) {
        String URL_ViaCep = "https://viacep.com.br/ws/" + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        ViaCepDTO viaCep = restTemplate.getForObject(URL_ViaCep, ViaCepDTO.class, cep);
        if (viaCep != null) {
            return EnderecoDTO.builder()
                    .api("ViaCep")
                    .cep(viaCep.getCep())
                    .logradouro(viaCep.getLogradouro())
                    .bairro(viaCep.getBairro())
                    .cidade(viaCep.getLocalidade())
                    .estado(viaCep.getUf())
                    .build();
        }
        return null;
    }
}
