package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CepAberto {

    private Cidade cidade;
    private Estado estado;
    private String bairro;
    private String cep;
    private String logradouro;

    @Data
    public static class Cidade{
        private String nome;
    }

    @Data
    public static class Estado{
        private String sigla;
    }
}


