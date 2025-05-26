import java.util.InputMismatchException;

public class Pessoa {
    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        try {
            if (idade > 150 || idade < 0) {
                throw new IdadeInvalidaException();
            }
            this.idade = idade;
        } catch (IdadeInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Encerrando verificação de idade.");
        }
    }
}
