package prova;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		System.out.print("Carlos digite o seu salário: ");
		double salarioCarlos = enter.nextDouble();
		double salarioJoao = salarioCarlos / 3;
		int mes = 0;
		while (salarioCarlos > salarioJoao) {
			salarioCarlos = salarioCarlos * 1.02;
			salarioJoao = salarioJoao * 1.05;
			mes++;
		}
		System.out.println("Serão necessários " + mes + " meses para o João ultrapassar o Carlos.");
		enter.close();
	}
}
