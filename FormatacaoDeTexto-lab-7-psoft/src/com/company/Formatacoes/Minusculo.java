package com.company.Formatacoes;

import com.company.Formato;

public class Minusculo implements Formato {
    @Override
    public String formataTexto(String texto) {
        return texto.toLowerCase();
    }
}
