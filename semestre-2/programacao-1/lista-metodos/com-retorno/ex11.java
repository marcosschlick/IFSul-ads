import java.util.Random;
import java.util.Scanner;

public class ex11 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o limite superior do número à ser gerado: ");
		int num1 = enter.nextInt();

		System.out.print("Digite o limite inferior do número à ser gerado: ");
		int num2 = enter.nextInt();

		int generated = generateNumber(num1, num2);

		System.out.println("O número gerado foi " + generated);

		enter.close();

	}

	public static int generateNumber(int num1, int num2) {

		Random random = new Random();

		int generated = random.nextInt(num1 - num2) + num2;
		return generated;
	}

}
