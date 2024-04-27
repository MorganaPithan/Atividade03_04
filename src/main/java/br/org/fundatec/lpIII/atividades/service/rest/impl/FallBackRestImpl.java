package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.EnderecoDTO;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalCepRestService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FallBackRestImpl implements ExternalCepRestService {
    private final List<String> fallbackOrder;
    private List<ExternalCepRestService> externalImpl =
            List.of(
                    new CepAbertoRestServiceImpl(),
                    new BrasilApiRestServiceImpl(),
                    new ViaCepRestServiceImpl()
            );

    @Override
    public EnderecoDTO searchByCep(String cep) {

        EnderecoDTO response = null;
        for (ExternalCepRestService externalService : externalImpl) {
            try {
                 response = externalService.searchByCep(cep);
                 break;
            } catch (RuntimeException ex) {
                continue;
            }
        }
        return response;
    }

}
