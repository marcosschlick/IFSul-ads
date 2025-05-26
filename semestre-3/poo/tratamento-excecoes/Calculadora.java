import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner enter = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        String operacao = "";

        try {
            System.out.println("Digite dois números inteiros:");

            System.out.print("Número 1: ");
            num1 = obterNumero();

            System.out.print("Número 2: ");
            num2 = obterNumero();

            System.out.print("Digite uma operação matemática (+, -, * ou /): ");
            operacao = enter.next();

            calcular(operacao, num1, num2);

        } finally {

            System.out.println("Operação finalizada.");

        }
    }

    private static void calcular(String operacao, int num1, int num2) {
        double resultado = 0;
        boolean operacaoValida = true;

        switch (operacao) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "/":
                try {
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    resultado = (double) num1 / num2;
                } catch (ArithmeticException e) {
                    System.out.println("Não pode dividir por zero.");
                    operacaoValida = false;
                }
                break;
            case "*":
                resultado = num1 * num2;
                break;
            default:
                System.out.println("Operação inválida.");
                operacaoValida = false;
        }

        if (operacaoValida) {
            System.out.println("Resultado: " + resultado);
        }
    }

    public static int obterNumero() {
        Scanner enter = new Scanner(System.in);
        while (true) {
            try {
                return enter.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                enter.nextLine();
            }
        }
    }
}