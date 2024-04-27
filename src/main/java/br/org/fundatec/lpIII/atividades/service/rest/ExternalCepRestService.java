package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;

public interface ExternalCepRestService {
    EnderecoDTO searchByCep(String cep);
}
