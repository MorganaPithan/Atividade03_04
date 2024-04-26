package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Location;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalGoogleApiRestService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GoogleApiServiceImpl implements ExternalGoogleApiRestService {

    @Override
    public Location searchByAddress(String address) {
        String URL_GOOGLEAPI = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=AAIzaSyAS_Tl063aK99-WGjytiMwWEXzbWYaPFWI";
        RestTemplate restTemplate = new RestTemplate();
        Location addressGoogle = restTemplate.getForObject(URL_GOOGLEAPI, Location.class, address);
        if (addressGoogle != null) {
            return Location.builder()
//                    .address(address)
                    .lat(addressGoogle.getLat())
                    .lng(addressGoogle.getLng())
                    .build();
        }
        return null;
    }
}
