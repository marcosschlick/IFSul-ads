import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws ParseException {
        Util util = new Util();

        Aluno[] matrizAluno = new Aluno[5000000];
        long inserirMatriz = util.cadastrarAlunos(matrizAluno);
        long ordenarMatriz = util.ordenarAlunos(matrizAluno);
        long exportarMatriz = util.exportarAlunos(matrizAluno, "alunos_matriz.csv");

        ArrayList<Aluno> arrayListAlunos = new ArrayList<>();
        long inserirArrayList = util.cadastrarAlunos(arrayListAlunos);
        long ordenarArrayList = util.ordenarAlunos(arrayListAlunos);
        long exportarArrayList = util.exportarAlunos(arrayListAlunos, "alunos_arraylist.csv");

        LinkedList<Aluno> linkedListAlunos = new LinkedList<>();
        long inserirLinkedList = util.cadastrarAlunos(linkedListAlunos);
        long ordenarLinkedList = util.ordenarAlunos(linkedListAlunos);
        long exportarLinkedList = util.exportarAlunos(linkedListAlunos, "alunos_linkedlist.csv");

        Vector<Aluno> vectorAlunos = new Vector<>();
        long inserirVector = util.cadastrarAlunos(vectorAlunos);
        long ordenarVector = util.ordenarAlunos(vectorAlunos);
        long exportarVector = util.exportarAlunos(vectorAlunos, "alunos_vector.csv");

        System.out.printf("%-12s %-12s %-16s %-17s %-10s%n", "Operação", "Matriz (ms)", "ArrayList (ms)", "LinkedList (ms)", "Vector (ms)");
        System.out.printf("%-12s %-12d %-16d %-17d %-10d%n", "Cadastro", inserirMatriz, inserirArrayList, inserirLinkedList, inserirVector);
        System.out.printf("%-12s %-12d %-16d %-17d %-10d%n", "Ordenação", ordenarMatriz, ordenarArrayList, ordenarLinkedList, ordenarVector);
        System.out.printf("%-12s %-12d %-16d %-17d %-10d%n", "Exportação", exportarMatriz, exportarArrayList, exportarLinkedList, exportarVector);
    }
}