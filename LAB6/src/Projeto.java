
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


import java.util.List;

public class Projeto {
	public int dias;
	public boolean isEntregue() {
		return false;
	}
	public List<Cliente> getClientes() {
		return null;
	}

	public String checaPrazo(){
		// verifica prazo do projeto
		if (this.getDias() < 90) {
			// verifica se projeto ainda está em andamento
			if (!this.isEntregue()) {
				// projeto ainda em andamento e com prazo curto para entrega
				return "Projeto está apertado" ;
			} else {
				return "Projeto entregue";}
		} else {
			List<Cliente> clients = this.getClientes();
			for (Cliente c : clients) {
				c.avisaAtraso(this.getDias());
			}
			return "Projeto atrasado";
		}
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
}



