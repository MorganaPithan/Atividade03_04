package br.org.fundatec.lpIII.atividades.service;

import br.org.fundatec.lpIII.atividades.model.Location;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalGoogleApiRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleApiService {
    private final ExternalGoogleApiRestService externalGoogleApiRestService;

    public Location searchAddress(String address) {
        return externalGoogleApiRestService.searchByAddress(address);
    }
}
