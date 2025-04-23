public abstract class Animal {
    private String nome;
    private int numeroPernas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroPernas() {
        return numeroPernas;
    }

    public void setNumeroPernas(int numeroPernas) {
        this.numeroPernas = numeroPernas;
    }


    public void andarAnimal(int distancia) {
        String unidade = "metros";

        if (distancia >= 1000) {
            unidade = "quilômetro";
            System.out.println("O " + getClass().getSimpleName() + " usou suas " + this.numeroPernas + " pernas para andar " + ((double)distancia / 1000) + " " + unidade);
            return;
        }
        System.out.println("O " + getClass().getSimpleName() + " usou suas " + this.numeroPernas + " pernas para andar " + distancia + " " + unidade);
    }
}
