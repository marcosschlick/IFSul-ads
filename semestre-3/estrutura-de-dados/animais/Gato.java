public class Gato extends Animal implements Carnivoro{

    private String som;
    private String cor;

    public Gato(String som, String cor) {
        this.som = som;
        this.cor = cor;
    }

    @Override
    public void entregarComidaC() {
        System.out.println("O " + getClass().getSimpleName() + " " + tipoC  + " recebeu uma porção de " + comidaC);
    }
}
