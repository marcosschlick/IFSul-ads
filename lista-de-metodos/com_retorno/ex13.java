package com_retorno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex13 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean end;

		do {
			System.out.print("Digite um número inteiro para lista: ");
			numbers.add(enter.nextInt());

			System.out.print("Deseja parar a inserção? ");
			end = (enter.next().equalsIgnoreCase("Sim") ? true : false);
		} while (!end);

		int lower = getLower(numbers);

		System.out.println("O menor número do array é " + lower);

		enter.close();
	}

	public static int getLower(ArrayList<Integer> numbers) {
		Collections.sort(numbers.reversed());
		return numbers.getLast();
	}

}
