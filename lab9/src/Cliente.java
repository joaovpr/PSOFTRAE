//IMPLEMENTAÇÃO DO LAB 9 PSOFT
//JOÃO VITOR PATRÍCIO ROMÃO - MATRÍCULA: 118211058


public class Cliente {
	public static void main(String[] args) {
	    FabricaBolo fBoloBaunilha = new Baunilha();
		FabricaBolo fBoloChocolate = new Chocolate();
		//set do sabor da cobertura para teste
		fBoloBaunilha.setMorango();
		fBoloChocolate.setCaramelo();
		//fabricação dos bolos com massa e cobertura desejadas
		fBoloBaunilha.prepararBolo();
		fBoloChocolate.prepararBolo();
	}
}
