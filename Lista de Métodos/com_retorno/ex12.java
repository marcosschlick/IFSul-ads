package com_retorno;

import java.util.Scanner;

public class ex12 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o ano à verificar se é bissexto: ");
		int year = enter.nextInt();

		
		System.out.println(isLeap(year) ? "Sim, é bissexto!" : "Não, não é bissexto!");
		
		
		
		enter.close();

	}

	public static boolean isLeap(int year) {

		return (year % 4 != 0 & year % 400 != 0);

	}

}
