package semestre_3.poo.heranca;

public class Professor extends Pessoa{

    private String[] disciplinas;
    private boolean temDoutorado;
    private boolean chato;
    private String graduacao;
    private Aluno alunoFavorito;

    public String[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean isTemDoutorado() {
        return temDoutorado;
    }

    public void setTemDoutorado(boolean temDoutorado) {
        this.temDoutorado = temDoutorado;
    }

    public boolean isChato() {
        return chato;
    }

    public void setChato(boolean chato) {
        this.chato = chato;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public Aluno getAlunoFavorito() {
        return alunoFavorito;
    }

    public void setAlunoFavorito(Aluno alunoFavorito) {
        this.alunoFavorito = alunoFavorito;
    }

    public void avaliarAluno(Aluno aluno) {
        if (aluno.equals(this.alunoFavorito)) {
            System.out.println(aluno.getNome() + ": Aprovado com nota máxima queridão!!");
        } else {
            System.out.println(aluno.getNome() + ": REPROVADO SEU BURRÃO...");
        }
    }

    public void fazerDoutorado() {
        this.temDoutorado = true;
        System.out.println(super.getNome() + " é Doutor.");
    }

    public void voltarParaCidadeNatal() {
        System.out.println("Já foi...");
    }

}
