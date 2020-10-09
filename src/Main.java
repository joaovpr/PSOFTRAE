
//LAB 06 PSOFT
// JOÃO VITOR PATRICIO ROMÃO - 118211058



//		BAD SMELLS ENCONTRADOS:

//		-Long method no metodo checar() de gerente.
//		-Classe preguiçosa na classe Cliente.
//		-Inveja de recursos na classe Gerente.

//      SOLUÇÕES TOMADAS:

//		-Codigo de chegar prazo foi tirado da responsabilidade de Gerente, agora o Propjeto que faz isso e o gerente apenas solicita.
//      -Mudança de nome na variavel d ---> dias
//      -criação de get e set para a variavel dias para melhorar o acesso a váriavel
//


//Essa classe foi criada para compilação e testes
public class Main {

    public static void main(String[] args) {
	    Gerente g = new Gerente();
	    Projeto p = new Projeto();
	    Cliente c = new Cliente();

	    p.setDias(89);

	    System.out.println(g.checar(p));
    }
}
