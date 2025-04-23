import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		System.out.print("Digite a temperatura em Celsius à converter para Fahrenheit: ");
		double celsius = enter.nextDouble();

		double result = celsiusToFahrenheit(celsius);

		System.out.printf("Em Fahrenheit: %.2f", result);

		enter.close();
	}

	public static double celsiusToFahrenheit(double celsius) {

		double fahrenheit = celsius * 1.8 + 32;
		return fahrenheit;

	}

}
