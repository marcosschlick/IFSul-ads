package com_retorno;

import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite um numero para obter a sua raiz quadrada: ");
		double num = enter.nextDouble();

		double result = getRoot(num);

		System.out.printf("A raiz quadrada é %.2f", result);

		enter.close();

	}

	public static double getRoot(double num) {
		return Math.sqrt(num);
	}

}
