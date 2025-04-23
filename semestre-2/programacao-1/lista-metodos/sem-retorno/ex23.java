import java.util.ArrayList;
import java.util.Scanner;

public class ex23 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean end;
		do {
			System.out.print("Digite um número inteiro para lista: ");
			numbers.add(enter.nextInt());

			System.out.print("Deseja parar a inserção? ");
			end = (enter.next().equalsIgnoreCase("Sim") ? true : false);
		} while (!end);

		printSum(numbers);

		enter.close();

	}

	public static void printSum(ArrayList<Integer> numbers) {
		double total[] = { 0 };
		numbers.forEach(n -> total[0] += n);
		System.out.println("A soma do Array é " + total[0]);
	}
}
