package com_retorno;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite um número inteiro para verificar se é par: ");
		int num = enter.nextInt();

		System.out.println(isPar(num) ? "Sim, é par!" : "Não, é ímpar!");

		enter.close();

	}

	public static boolean isPar(int num) {
		return (num % 2 == 0);
	}
}
