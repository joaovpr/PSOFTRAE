
//LAB 06 PSOFT
// JOÃO VITOR PATRICIO ROMÃO - 118211058



//		BAD SMELLS ENCONTRADOS:

//		-Long method no metodo checar() de gerente.
//		-Classe preguiçosa na classe Cliente.
//		-Inveja de recursos na classe Gerente.

//      SOLUÇÕES TOMADAS:

//		-Codigo de chegar prazo foi tirado da responsabilidade de Gerente, agora o Propjeto que faz isso e o gerente apenas solicita.
//



import java.util.List;

public class Gerente {
	public String checar( Projeto p ) {
		return p.checaPrazo();
	}
}


