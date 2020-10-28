package com.company;

public class Publicar {


    public Publicar() {}

    public String fazerPublicacao(String texto, Formato formato){
        return formato.formataTexto(texto);
    }
}
