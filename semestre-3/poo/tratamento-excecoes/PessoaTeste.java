public class PessoaTeste {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(511);
        System.out.println(pessoa.getIdade());
        pessoa.setIdade(-20);
        System.out.println(pessoa.getIdade());
    }
}
