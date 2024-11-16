package com_retorno;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite um número inteiro para calcular o seu fatorial: ");
		int num = enter.nextInt();

		long result = getFactorial(num);
		System.out.println("O resultado é: " + result);

		enter.close();
	}

	public static long getFactorial(int num) {
		long total = num;
		while (num > 1) {
			num--;
			total *= num;
		}
		return total;
	}

}
