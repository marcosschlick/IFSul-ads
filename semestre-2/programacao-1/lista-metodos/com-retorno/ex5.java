import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite o número 1 à comparar: ");
		double num1 = enter.nextDouble();
		System.out.print("Digite o número 2 à comparar: ");
		double num2 = enter.nextDouble();
		System.out.print("Digite o número 3 à comparar: ");
		double num3 = enter.nextDouble();

		double bigger = getBigger(num1, num2, num3);

		System.out.println("O maior número é o " + bigger);

		enter.close();
	}

	public static double getBigger(double num1, double num2, double num3) {
		if (num1 > num2 & num1 > num3) {
			return num1;
		} else if (num2 > num1 & num2 > num3) {
			return num2;
		} else {
			return num3;
		}
	}

}
