import java.util.ArrayList;
import java.util.Scanner;

public class ex21 {

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

		printArray(numbers);

		enter.close();

	}

	public static void printArray(ArrayList<Integer> numbers) {
		numbers.forEach(n -> System.out.println(n));
	}

}
