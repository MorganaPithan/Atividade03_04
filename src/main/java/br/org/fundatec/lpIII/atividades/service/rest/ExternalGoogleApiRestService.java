package br.org.fundatec.lpIII.atividades.service.rest;

import br.org.fundatec.lpIII.atividades.model.Location;


public interface ExternalGoogleApiRestService {
    Location searchByAddress(String address);
}
