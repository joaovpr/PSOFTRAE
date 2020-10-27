public abstract class FabricaBolo {

    public void prepararBolo() {
        fazerMassa();
        levarAoForno();
        fazerCobertura();
        decorarBolo();
    }

    private void levarAoForno() { System.out.println("Leva ao forno");}
    public abstract void fazerCobertura();
    public abstract void fazerMassa();
    private void decorarBolo() { System.out.println("Decora bolo"); }

}
