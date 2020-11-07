
//ALUNO: João Vitor Patricio Romão
//MATRICULA: 118211058
//LAB 10 PSOFT
//Neste laboratório foi realizado refatoramento do código aplicando o padrão state para a variabilidade dos estados so Mario.



public class Mario {
	public SituacaoMario situacao = new Pequeno();
	public long pontuacao = 0;

	public void pegarCogumelo() {
		situacao.pegarCogumelo(this);
	}
	public void levarDano() throws Exception {
		situacao.levarDano(this);
	}
	public void pegarFlor() {
	    situacao.pegarFlor(this);
	}

    public long getPontuacao() {
        return pontuacao;
    }
}
