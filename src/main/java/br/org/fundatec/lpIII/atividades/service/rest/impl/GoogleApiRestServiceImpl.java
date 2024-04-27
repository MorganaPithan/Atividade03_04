package br.org.fundatec.lpIII.atividades.service.rest.impl;

import br.org.fundatec.lpIII.atividades.model.Location;
import br.org.fundatec.lpIII.atividades.service.rest.ExternalGoogleApiRestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GoogleApiRestServiceImpl implements ExternalGoogleApiRestService {

    @Override
    public Location searchByAddress(String address) {
        String URL_GOOGLEAPI = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=AIzaSyARagy3X2XFVQ9V5GR4795SiVV0BkPDMMA";

        var restTemplate = new RestTemplate();
        var objectMapper = new ObjectMapper();
        ResponseEntity<String> response = restTemplate.getForEntity(URL_GOOGLEAPI, String.class);
        String responseBody = response.getBody();

        JsonNode responseJson = null;
        try {
            responseJson = objectMapper.readTree(responseBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Double lat = responseJson
                .at(" /results/0/geometry/location/lat")
                .asDouble();
        Double lng = responseJson
                .at(" /results/0/geometry/location/lng")
                .asDouble();
//        RestTemplate restTemplate = new RestTemplate();
//        Location addressGoogle = restTemplate.getForObject(URL_GOOGLEAPI, Location.class, address);
//        if (addressGoogle != null) {
//            return Location.builder()
//                    .address(address)
//                    .lat(addressGoogle.getLat())
//                    .lng(addressGoogle.getLng())
//                    .build();
//        }
//        return null;
        return null;
    }
}
