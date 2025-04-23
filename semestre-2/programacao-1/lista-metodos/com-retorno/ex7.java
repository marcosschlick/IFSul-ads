import java.util.ArrayList;
import java.util.Scanner;

public class ex7 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		ArrayList<Double> numbers = new ArrayList<Double>();
		boolean end;

		do {
			System.out.print("Digite um número para obter a média: ");
			numbers.add(enter.nextDouble());
			
			System.out.print("Deseja parar a inserção? ");
			end = (enter.next().equalsIgnoreCase("Sim") ? true : false);
		} while (!end);

		double sumResult = mediaArray(numbers);

		System.out.printf("A soma do array é %.2f", sumResult);

		enter.close();
	}

	public static double mediaArray(ArrayList<Double> numbers) {
		double total[] = { 0 };
		numbers.forEach(n -> total[0] += n);
		return total[0] / numbers.size();
	}

}
