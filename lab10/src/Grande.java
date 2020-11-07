
//ALUNO: João Vitor Patricio Romão
//MATRICULA: 118211058
//LAB 10 PSOFT
//Neste laboratório foi realizado refatoramento do código aplicando o padrão state para a variabilidade dos estados so Mario.

public class Grande extends SituacaoMario {

    public void pegarCogumelo(Mario m) {m.pontuacao+=1000;}
    public void levarDano(Mario m) {m.situacao = new Pequeno();}
    public void pegarFlor(Mario m) {m.situacao = new FlorDeFogo();}
}
