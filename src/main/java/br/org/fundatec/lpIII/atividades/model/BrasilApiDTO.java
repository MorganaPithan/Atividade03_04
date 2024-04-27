package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrasilApiDTO {
    private String api;
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;

    @Override
    public String toString() {
        return "BrasilApi{" +
                "cep='" + cep + '\'' +
                ", estado='" + state + '\'' +
                ", cidade='" + city + '\'' +
                ", bairro='" + neighborhood + '\'' +
                ", rua='" + street + '\'' +
                '}';
    }
}
