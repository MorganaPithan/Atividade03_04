package br.org.fundatec.lpIII.atividades.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;


@Builder
@Data
public class CepAberto {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}


