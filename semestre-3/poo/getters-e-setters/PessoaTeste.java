public class PessoaTeste {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();

        pessoa1.setNome("Marcos");
        pessoa1.setIdade(20);
        pessoa1.setAltura(1.85);

        pessoa2.setNome("William");
        pessoa2.setIdade(21);
        pessoa2.setAltura(1.85);

        System.out.println("Nome: " + pessoa1.getNome() + " | idade: " + pessoa1.getIdade() + " | altura: " + pessoa1.getAltura());
        System.out.println("Nome: " + pessoa2.getNome() + " | idade: " + pessoa2.getIdade() + " | altura: " + pessoa2.getAltura());

    }
}
