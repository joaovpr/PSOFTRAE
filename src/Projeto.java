
//LAB 06 PSOFT
// JOÂO VITOR PATRICIO ROMÂO - 118211058



//		BAD SMELLS ENCONTRADOS:

//		-Long method no metodo checar() de gerente.
//		-Classe preguiçosa na classe Cliente.
//		-Inveja de recursos na classe Gerente.

//      SOLUÇÕES TOMADAS:

//		-Codigo de chegar prazo foi tirado da responsabilidade de Gerente, agora o Propjeto que faz isso e o gerente apenas solicita.
//


import java.util.List;

public class Projeto {
	public int d;
	public boolean isEntregue() {
		return false;
	}
	public List<Cliente> getClientes() {
		return null;
	}

	public String checaPrazo(){
		// verifica prazo do projeto
		if (this.d < 90) {
			// verifica se projeto ainda está em andamento
			if (!this.isEntregue()) {
				// projeto ainda em andamento e com prazo curto para entrega
				return "Projeto está apertado" ;
			} else {
				return "Projeto entregue";}
		} else {
			List<Cliente> clients = this.getClientes();
			for (Cliente c : clients) {
				c.avisaAtraso(this.d);
			}
			return "Projeto atrasado";
		}
	}
}



