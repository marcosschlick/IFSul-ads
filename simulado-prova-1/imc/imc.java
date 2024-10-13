import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class imc {

	public static void main(String[] args) {

		PanelIMC panel = new PanelIMC();

		int result = JOptionPane.showConfirmDialog(null, panel, "Digite as informações do cliente",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {

			String name = panel.getName();
			String birthdate = panel.getBirthDate();
			String adress = panel.getAddress();
			double height = panel.getHeightM();
			double weight = panel.getWeightKg();
			String sex = panel.getSexo();
			double imc = weight / (height * height);

			String message = String.format(
					"Nome: %s\nData de Nascimento: %s\nEndereço: %s\nSexo: %s\nAltura: %.2f m\nPeso: %.2f kg\nIMC: %.2f\nClassificação IMC: %s\n %s",
					name, birthdate, adress, sex, height, weight, imc, getIMC(sex, imc), getDate(birthdate));

			JOptionPane.showMessageDialog(null, message, "Resultados", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static String getIMC(String sex, Double imc) {
		String IMC = "";
		if (sex.equalsIgnoreCase("Masculino")) {
			if (imc < 20.7) {
				IMC = "Abaixo do peso";
			} else if (imc >= 20.7 && imc <= 26.4) {
				IMC = "Peso ideal";
			} else if (imc >= 26.5 && imc <= 27.8) {
				IMC = "Pouco acima do peso";
			} else if (imc >= 27.9 && imc <= 31.1) {
				IMC = "Acima do peso";
			} else if (imc >= 31.2) {
				IMC = "Obesidade";
			}
		} else if (sex.equalsIgnoreCase("Feminino")) {
			if (imc < 19.1) {
				IMC = "Abaixo do peso";
			} else if (imc >= 19.1 && imc <= 25.8) {
				IMC = "Peso ideal";
			} else if (imc >= 25.9 && imc <= 27.3) {
				IMC = "Pouco acima do peso";
			} else if (imc >= 27.4 && imc <= 32.3) {
				IMC = "Acima do peso";
			} else if (imc >= 32.4) {
				IMC = "Obesidade";
			}
		}
		return IMC;
	}

	public static String getDate(String birthday) {
		int d = 0;
		int m = 0;
		int y = 0;

		String regex = "(0?\\d{1,2})/(0?\\d{1,2})/(\\d{1,4})";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(birthday);

		if (matcher.find()) {
			d = Integer.parseInt(matcher.group(1));
			m = Integer.parseInt(matcher.group(2));
			y = Integer.parseInt(matcher.group(3));
		}

		LocalDate birthDate = LocalDate.of(y, m, d);
		LocalDate finalDate = LocalDate.now();

		Period periodo = Period.between(birthDate, finalDate);

		return String.format("Você tem %d anos, %d meses e %d dias.", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
	}

}
