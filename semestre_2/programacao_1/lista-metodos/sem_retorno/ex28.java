package sem_retorno;

import java.util.ArrayList;
import java.util.Scanner;

public class ex28 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		ArrayList<String> words = new ArrayList<String>();
		boolean end;

		do {
			System.out.print("Digite uma palavra para lista: ");
			words.add(enter.next());

			System.out.print("Deseja parar a inserção? ");
			end = (enter.next().equalsIgnoreCase("Sim") ? true : false);
		} while (!end);

		printArray(words);

		enter.close();

	}

	public static void printArray(ArrayList<String> words) {
		words.forEach(w -> System.out.println(w));

	}

}
