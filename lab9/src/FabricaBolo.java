//IMPLEMENTAÇÃO DO LAB 9 PSOFT
//JOÃO VITOR PATRÍCIO ROMÃO - MATRÍCULA: 118211058


//PROBLEMAS NO PROJETO ORIGINAL:
//REPETIÇÃO DE CÓDIGO EM CLASSES DIFERENTES
//NÃO PERMITE VARIABILIDADE NOS TIPOS DE BOLO

//SOLUÇÕES:
//APLICAÇÃO DO PADRÃO TEMPLATE METHOD NAS CLASSES PARA EVITAR A REPETIÇÃO DE ALGORITIMOS
//APLICAÇÃO DO PADRÃO BRIDGE PARA PERMITIR A VARIABILIDADE NOS TIPOS DE COBERTURA E ASSIM PERMITIR MAIS COMBINAÇÕES DE BOLOS





public abstract class FabricaBolo {

    public Cobertura cobertura;


    public void prepararBolo() {
        fazerMassa();
        levarAoForno();
        cobertura.fazerCobertura();
        decorarBolo();
    }

    public void setMorango(){
        this.cobertura = new Morango();
    }

    public void setCaramelo(){
        this.cobertura = new Caramelo();
    }

    private void levarAoForno() { System.out.println("Leva ao forno");}
    public abstract void fazerMassa();
    private void decorarBolo() { System.out.println("Decora bolo"); }

}
