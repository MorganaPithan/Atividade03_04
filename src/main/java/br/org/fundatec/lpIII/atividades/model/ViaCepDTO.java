package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViaCepDTO {
    private String api;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    @Override
    public String toString() {
        return "ViaCep{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
