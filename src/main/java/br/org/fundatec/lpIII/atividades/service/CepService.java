package br.org.fundatec.lpIII.atividades.service;

import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CepService {
//    private final ExternalCepFactory externalCepFactory;



    private final ExternalCepRestService externalCepRestService;


    public EnderecoDTO searchEndereco(String cep) {
//        return externalCepFactory.create(apiConfig)
//                .searchByCep(cep);
        return externalCepRestService.searchByCep(cep);
    }

}
