package br.org.fundatec.lpIII.atividades.controller;

import br.org.fundatec.lpIII.atividades.model.Location;
import br.org.fundatec.lpIII.atividades.service.GoogleApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/address/geografic-location")
@RequiredArgsConstructor
public class AddressController {

    private final GoogleApiService googleApiService;
    @GetMapping
    public Location getAddressByLogradouro(@RequestParam("address") String address){
        return googleApiService.searchAddress(address);
    }
}
