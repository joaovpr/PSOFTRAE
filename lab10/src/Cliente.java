
//ALUNO: João Vitor Patricio Romão
//MATRICULA: 118211058
//LAB 10 PSOFT
//Neste laboratório foi realizado refatoramento do código aplicando o padrão state para a variabilidade dos estados so Mario.


public class Cliente {
	public static void main(String[] args) {
		Mario mario = new Mario();
		try {
			mario.pegarCogumelo();
			mario.levarDano();
			mario.pegarFlor();
			mario.pegarFlor();
			mario.levarDano();
			mario.levarDano();
			mario.levarDano();
			mario.levarDano();
			mario.levarDano();

		} catch (Exception e) {

			System.out.println("Acabou o jogo");
		}

	}
}

