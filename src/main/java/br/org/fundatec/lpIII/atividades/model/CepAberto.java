package br.org.fundatec.lpIII.atividades.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class CepAberto {


    @Value
    private static class Cep{
        private String cep;
        private double altitude;
        private double latitude;
        private double longitude;
        private String bairro;
        private String logradouro;
        private String cidade;
        private String estado;

        @Value
        private static class Cidade{
            private String nome;
            private Integer ddd;
            private String ibge;
        }

        @Value
        private static class Estado{
            private String sigla;
        }
    }

}
