package com.company.Formatacoes;

import com.company.Formato;

public class Negrito implements Formato {
    @Override
    public String formataTexto(String texto) {
        return "\033[1m" +texto+"\033[1m";
    }
}
