package com.example.avaliacaobruno.model;

public class ConfiguracaoBO {

    public static boolean valida(Configuracao configuracao){
        return configuracao!= null && configuracao.getMinimo()!= null && configuracao.getMaximo()!=null &&
                configuracao.getMaximo() >= configuracao.getMinimo();
    }
}
