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
