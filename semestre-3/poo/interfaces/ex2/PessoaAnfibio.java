package ex2;

public class PessoaAnfibio implements Caminhavel, Nadavel {
    @Override
    public void caminhar() {
        System.out.println("Caminhando...");
    }

    @Override
    public void nadar() {
        System.out.println("Nadando...");
    }
}
