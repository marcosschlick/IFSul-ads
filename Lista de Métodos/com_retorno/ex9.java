package com_retorno;

import java.util.Scanner;

public class ex9 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite a base à ser exponenciada: ");
		int base = enter.nextInt();

		System.out.print("Digite o expoente: ");
		int exponent = enter.nextInt();

		int result = getPow(base, exponent);

		System.out.println("O resultado da exponenciação é " + result);

		enter.close();
	}

	public static int getPow(int base, int exponent) {

		int result = (int) Math.pow(base, exponent);

		return result;
	}

}
