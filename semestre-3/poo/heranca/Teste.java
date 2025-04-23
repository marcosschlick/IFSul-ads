public class Teste {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Marcos Schlick");
        aluno1.setAltura(185);
        aluno1.setIdade(20);
        aluno1.setPeso(97.5);
        aluno1.setTemPet(true);
        aluno1.setCanetasRoubadas(0);
        aluno1.setCarater(false);
        aluno1.setNota(10);
        aluno1.setNerd(false);
        aluno1.setPreguicoso(true);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("William Meirelles");
        aluno2.setAltura(182);
        aluno2.setIdade(99);
        aluno2.setPeso(82.5);
        aluno2.setTemPet(true);
        aluno2.setCanetasRoubadas(5);
        aluno2.setCarater(true);
        aluno2.setNota(10);
        aluno2.setNerd(true);
        aluno2.setPreguicoso(false);

        aluno1.comer("macarrão");
        aluno1.estudar();
        aluno2.passearComPet();
        aluno2.fazerAniversario();

        Professor professor = new Professor();
        professor.setNome("Vinicius Silva");
        professor.setAltura(165);
        professor.setIdade(35);
        professor.setPeso(65);
        professor.setTemPet(true);
        professor.setDisciplinas(new String[]{"POO", "REDES"});
        professor.setTemDoutorado(false);
        professor.setChato(false);
        professor.setGraduacao("Ciência da computação");
        professor.setAlunoFavorito(aluno2);

        professor.avaliarAluno(aluno2);
        professor.avaliarAluno(aluno1);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Paizinho");
        funcionario.setAltura(165);
        funcionario.setIdade(55);
        funcionario.setPeso(85);
        funcionario.setTemPet(true);
        funcionario.setCargo("Porteiro");
        funcionario.setSalario(10000);
        funcionario.setCargaHorariaDiaria(6);
        funcionario.setCodigo("6969696969");
        funcionario.setSetor("COMAG");

        funcionario.receberAumento(5);
        funcionario.darAtestado();
        funcionario.darAtestado();
        funcionario.darAtestado();
        funcionario.darAtestado();



    }
}
