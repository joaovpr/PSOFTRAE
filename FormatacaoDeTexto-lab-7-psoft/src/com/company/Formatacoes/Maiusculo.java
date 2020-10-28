package com.company.Formatacoes;

import com.company.Formato;

public class Maiusculo implements Formato {
    @Override
    public String formataTexto(String texto) {
    return texto.toUpperCase();
    }
}
