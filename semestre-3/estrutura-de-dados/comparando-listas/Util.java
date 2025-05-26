import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {
    private Random random = new Random();
    private static final String[] nomes = {
            "Ana", "João", "Carlos", "Maria", "Pedro", "Juliana", "Lucas", "Fernanda",
            "Rafael", "Beatriz", "Gabriel", "Amanda", "Rodrigo", "Carolina", "Marcelo",
            "Isabela", "Thiago", "Larissa", "Bruno", "Patrícia", "Felipe", "Vanessa",
            "Daniel", "Tatiane", "Eduardo", "Mariana", "Vinícius", "Letícia", "Roberto", "Camila"
    };

    private static final String[] sobrenomes = {
            "Silva", "Souza", "Oliveira", "Costa", "Pereira", "Rodrigues", "Almeida", "Ferreira",
            "Santos", "Lima", "Ribeiro", "Martins", "Gonçalves", "Carvalho", "Araújo", "Melo",
            "Barbosa", "Castro", "Nunes", "Moreira", "Correia", "Cardoso", "Dias", "Teixeira",
            "Monteiro", "Ramos", "Gomes", "Mendes", "Freitas", "Andrade"
    };

    private String getNomeCompleto() {
        int nome = random.nextInt(30);
        int sobrenome = random.nextInt(30);
        return nomes[nome] + " " + sobrenomes[sobrenome];
    }

    private String getMatricula() {
        String matricula = "";
        for (int i = 0; i < 5; i++){
            matricula = matricula.concat(String.valueOf(random.nextInt(10))); // ✅
        }
        return matricula;
    }

    private DataNascimento getDataNascimento() {
        int anoMaximo = 2024;
        int anoMinimo = anoMaximo - 110;
        int ano = random.nextInt(anoMaximo - anoMinimo + 1) + anoMinimo;

        int mes = random.nextInt(12) + 1;

        LocalDate dataTmp = LocalDate.of(ano, mes, 1);
        int maxDia = dataTmp.lengthOfMonth();

        int dia = random.nextInt(maxDia) + 1;

        return new DataNascimento(dia, mes, ano);
    }

    public long cadastrarAlunos(List<Aluno> alunos) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            alunos.add(new Aluno(this.getNomeCompleto(), this.getMatricula(), this.getDataNascimento()));
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public long cadastrarAlunos(Aluno[] alunos) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            alunos[i] = new Aluno(this.getNomeCompleto(), this.getMatricula(), this.getDataNascimento());
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public long ordenarAlunos(List<Aluno> alunos) {
        long inicio = System.currentTimeMillis();
        Collections.sort(alunos);
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public long ordenarAlunos(Aluno[] alunos) {
        long inicio = System.currentTimeMillis();
        Arrays.sort(alunos);
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public long exportarAlunos(List<Aluno> alunos, String NOME_CSV) {
        long inicio = System.currentTimeMillis();

        new File("./planilhas").mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./planilhas/" + NOME_CSV))) {
            writer.write("Nome,Matricula,Data de Nascimento\n");
            for (Aluno aluno : alunos) {
                writer.write(aluno.getNome() + ","
                        + aluno.getMatricula() + ","
                        + aluno.getNascimento() + "\n");
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerar o arquivo " + NOME_CSV + ": " + e.getMessage());
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public long exportarAlunos(Aluno[] alunos, String NOME_CSV) {
        long inicio = System.currentTimeMillis();

        new File("./planilhas").mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./planilhas/" + NOME_CSV))) {
            writer.write("Nome,Matricula,Data de Nascimento\n");
            for (Aluno aluno : alunos) {
                writer.write(aluno.getNome() + ","
                        + aluno.getMatricula() + ","
                        + aluno.getNascimento() + "\n");
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerar o arquivo " + NOME_CSV + ": " + e.getMessage());
        }
        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

    public void imprimirAlunos(List<Aluno> alunos) {
        alunos.forEach(aluno -> System.out.println(aluno.getNome() + " " + aluno.getMatricula() + " " + aluno.getNascimento()));
    }
}
