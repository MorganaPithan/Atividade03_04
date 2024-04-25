package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepAberto {
    private String cidade;
    private String estado;
    private String bairro;
    private String cep;
    private String logradouro;

    @Override
    public String toString() {
        return "CepAberto{" +
                "cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                '}';
    }
}
