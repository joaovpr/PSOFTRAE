
//ALUNO: João Vitor Patricio Romão
//MATRICULA: 118211058
//LAB 10 PSOFT
//Neste laboratório foi realizado refatoramento do código aplicando o padrão state para a variabilidade dos estados so Mario.


public class Pequeno extends SituacaoMario {

    public void pegarCogumelo(Mario m) {m.situacao = new Grande();}
    public void levarDano(Mario m) throws Exception {throw new Exception("Mario morreu.");}
    public void pegarFlor(Mario m) {m.situacao = new FlorDeFogo();}
}
