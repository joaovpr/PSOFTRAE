
//LAB-7 PSOFT
//JOÃO VITOR PATRICIO ROMÃO - MATRICULA - 118211058



package com.company;

import com.company.Formatacoes.TipoFormato;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner(System.in);
        Publicar pub = new Publicar();
        TipoFormato form;
        String txt;
        System.out.println("---Digite o seu texto:---");
        txt = sc.nextLine();
        System.out.println("---Selecione a formatação: (NEGRITO, ITALICO, MAIUSCULO ou MINUSCULO)---");
        form = TipoFormato.valueOf(sc.nextLine());
        System.out.println(pub.fazerPublicacao(txt,form.obterFormato()));

    }
}
