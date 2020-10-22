package com.company.Formatacoes;

import com.company.Formato;

public class Italico implements Formato {
    @Override
    public String formataTexto(String texto) {
        return "\033[3m" +texto+"\033[0m";
    }
}
