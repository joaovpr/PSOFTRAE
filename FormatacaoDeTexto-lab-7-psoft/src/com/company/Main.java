
//LAB-7 PSOFT
//JOÃO VITOR PATRICIO ROMÃO - MATRICULA - 118211058



package com.company;

import com.company.Formatacoes.TipoFormato;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String txt = "Este eh um texto de exemplo";
        Publicar pub = new Publicar();

        TipoFormato form1 = TipoFormato.valueOf("NEGRITO");
        TipoFormato form2 = TipoFormato.valueOf("ITALICO");
        TipoFormato form3 = TipoFormato.valueOf("MAIUSCULO");
        TipoFormato form4 = TipoFormato.valueOf("MINUSCULO");


        System.out.println(pub.fazerPublicacao(txt,form1.obterFormato()));
        System.out.println(pub.fazerPublicacao(txt,form2.obterFormato()));
        System.out.println(pub.fazerPublicacao(txt,form3.obterFormato()));
        System.out.println(pub.fazerPublicacao(txt,form4.obterFormato()));

    }
}
