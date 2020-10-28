<<<<<<< HEAD
//IMPLEMENTAÇÃO DO LAB 9 PSOFT
//JOÃO VITOR PATRÍCIO ROMÃO - MATRÍCULA: 118211058
=======

>>>>>>> 02b12ba07291f2d4dedd144d43694982e26826af


public class Cliente {
	public static void main(String[] args) {
<<<<<<< HEAD
	    FabricaBolo fBoloBaunilha = new Baunilha();
		FabricaBolo fBoloChocolate = new Chocolate();
		//set do sabor da cobertura para teste
		fBoloBaunilha.setMorango();
		fBoloChocolate.setCaramelo();
		//fabricação dos bolos com massa e cobertura desejadas
=======
		FabricaBolo fBoloBaunilha = new BaunilhaComMorango();
		FabricaBolo fBoloChocolate = new ChocolateComCaramelo();
>>>>>>> 02b12ba07291f2d4dedd144d43694982e26826af
		fBoloBaunilha.prepararBolo();
		fBoloChocolate.prepararBolo();
	}
}
