package sem_retorno;

import java.util.Scanner;

public class ex20 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o limite superior: ");
		int num1 = enter.nextInt();

		System.out.print("Digite o limite inferior: ");
		int num2 = enter.nextInt();

		showPairs(num1, num2);

		enter.close();

	}

	public static void showPairs(int num1, int num2) {

		for (int i = num2; i <= num1; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

}
