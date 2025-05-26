public class Aluno implements Comparable<Aluno>{

    private String nome;
    private String matricula;
    private DataNascimento nascimento;

    public Aluno(String nome, String matricula, DataNascimento nascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public DataNascimento getNascimento() {
        return nascimento;
    }

    @Override
    public int compareTo(Aluno outroAluno) {
        return this.nome.compareTo(outroAluno.getNome());
    }
}
