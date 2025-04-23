public class Urso extends Animal implements Carnivoro, Herbivoro{

    private String som;
    private String cor;

    public Urso(String som, String cor) {
        this.som = som;
        this.cor = cor;
    }

    @Override
    public void entregarComidaC() {
        System.out.println("O " + getClass().getSimpleName() + " " + tipoC + " recebeu uma porção de " + comidaC);
    }

    @Override
    public void entregarComidaH() {
        System.out.println("O " + getClass().getSimpleName() + " " + tipoH + " recebeu uma porção de " + comidaH);
    }
}
