package com_retorno;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o numero 1 à somar: ");
		int num1 = enter.nextInt();
		System.out.print("Digite o numero 2 à somar: ");
		int num2 = enter.nextInt();

		int result = sum(num1, num2);

		System.out.println("O resultado é " + result);

		enter.close();
	}

	public static int sum(int num1, int num2) {

		return num1 + num2;
	}

}
