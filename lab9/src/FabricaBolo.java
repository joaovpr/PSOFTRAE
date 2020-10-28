public abstract class FabricaBolo {

<<<<<<< HEAD
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
=======
    public void prepararBolo() {
        fazerMassa();
        levarAoForno();
        fazerCobertura();
        decorarBolo();
    }

    private void levarAoForno() { System.out.println("Leva ao forno");}
    public abstract void fazerCobertura();
>>>>>>> 02b12ba07291f2d4dedd144d43694982e26826af
    public abstract void fazerMassa();
    private void decorarBolo() { System.out.println("Decora bolo"); }

}
