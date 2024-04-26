package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String address;
    private double lat;
    private double lng;

    @Override
    public String toString() {
        return "Address{" +
                "logradouro='" + address + '\'' +
                ", latitude=" + lat +
                ", longitude=" + lng +
                '}';
    }
}
