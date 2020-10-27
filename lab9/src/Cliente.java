


public class Cliente {
	public static void main(String[] args) {
		FabricaBolo fBoloBaunilha = new BaunilhaComMorango();
		FabricaBolo fBoloChocolate = new ChocolateComCaramelo();
		fBoloBaunilha.prepararBolo();
		fBoloChocolate.prepararBolo();
	}
}
