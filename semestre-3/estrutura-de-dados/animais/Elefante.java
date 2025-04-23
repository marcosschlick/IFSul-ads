public class Elefante extends Animal implements Herbivoro{

    private String som;
    private String cor;

    public Elefante(String som, String cor) {
        this.som = som;
        this.cor = cor;
    }

    @Override
    public void entregarComidaH() {
        System.out.println("O " + getClass().getSimpleName() + " " + tipoH + " recebeu uma porção de " + comidaH);
    }
}
