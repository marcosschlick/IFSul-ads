package sem_retorno;

import java.util.Scanner;

public class ex30 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite até quanto deseja imprimir os números pares: ");
		int limit = enter.nextInt();

		printPairs(limit);

		enter.close();
	}

	public static void printPairs(int limit) {

		for (int i = 1; i <= limit; i++) {

			if (i % 2 == 0) {
				System.out.print(i + " ");
			}

		}

	}
}