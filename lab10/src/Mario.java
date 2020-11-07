
//ALUNO: João Vitor Patricio Romão
//MATRICULA: 118211058
//LAB 10 PSOFT
//Neste laboratório foi realizado refatoramento do código aplicando o padrão state para a variabilidade dos estados so Mario.



public class Mario {
	public SituacaoMario situacao = new Pequeno();
	public long pontuacao = 0;

	public void pegarCogumelo() {
		if (situacao.getSit() == 0) {
			situacao = new Grande();
		} else if (situacao.getSit() == 1  || situacao.getSit() == 2) {
			pontuacao+=1000;
		}
	}
	public void levarDano() throws Exception {
		if (situacao.getSit() == 0) {
			throw new Exception("Mario morreu.");
		} else if (situacao.getSit() == 1) {
			situacao = new Pequeno();
		}else if (situacao.getSit() == 2) {
			situacao = new Grande();
		}
	}
	public void pegarFlor() {
		if (situacao.getSit() == 0 || situacao.getSit() == 1) {
			situacao = new FlorDeFogo();
		} else if (situacao.getSit() == 2) {
			pontuacao+=1000;
		}
	}

}
