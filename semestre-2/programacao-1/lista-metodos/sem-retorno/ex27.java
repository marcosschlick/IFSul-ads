import java.util.Scanner;

public class ex27 {

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);

		ex27_car car1 = new ex27_car("Volkswagen", "Virtus");
		car1.setColor("Azul");
		car1.setYear(2025);

		ex27_car car2 = new ex27_car("Ford", "Corcel");
		car2.setColor("Vermelho");
		car2.setYear(1977);

		printCar(car1);
		printCar(car2);

		enter.close();
	}

	public static void printCar(ex27_car car) {
		System.out.println(car.getModel() + " da marca " + car.getBrand() + " ano de fabricação " + car.getYear()
				+ " na cor " + car.getColor());

	}
}
