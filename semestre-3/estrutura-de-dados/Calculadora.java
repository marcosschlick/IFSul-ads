import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculadora {

    public static void main(String[] args) {

        JFrame janela = new JFrame();
        janela.setTitle("Calculadora");
        janela.setSize(500, 700);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);

        JLabel labelResultado = new JLabel();
        labelResultado.setHorizontalAlignment(JLabel.CENTER);
        labelResultado.setText("Resultado");
        labelResultado.setFont(new Font("", Font.BOLD, 35));
        labelResultado.setBounds(0, 500, 500, 100);
        labelResultado.setVisible(true);

        JLabel labelPrimeiroNumero = new JLabel();
        labelPrimeiroNumero.setHorizontalAlignment(JLabel.CENTER);
        labelPrimeiroNumero.setText("Digite o primeiro número:");
        labelPrimeiroNumero.setFont(new Font("", Font.BOLD, 30));
        labelPrimeiroNumero.setSize(500, 100);
        labelPrimeiroNumero.setLocation(0, 50);
        labelPrimeiroNumero.setVisible(true);
        janela.add(labelPrimeiroNumero);

        JTextField campoPrimeiroNumero = new JTextField();
        campoPrimeiroNumero.setSize(100, 50);
        campoPrimeiroNumero.setFont(new Font("", Font.BOLD, 20));
        campoPrimeiroNumero.setLocation(200, 150);
        campoPrimeiroNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        janela.add(campoPrimeiroNumero);

        JLabel labelSegundoNumero = new JLabel();
        labelSegundoNumero.setHorizontalAlignment(JLabel.CENTER);
        labelSegundoNumero.setText("Digite o segundo número:");
        labelSegundoNumero.setFont(new Font("", Font.BOLD, 30));
        labelSegundoNumero.setSize(500, 100);
        labelSegundoNumero.setLocation(0, 200);
        labelSegundoNumero.setVisible(true);
        janela.add(labelSegundoNumero);

        JTextField campoSegundoNumero = new JTextField();
        campoSegundoNumero.setSize(100, 50);
        campoSegundoNumero.setFont(new Font("", Font.BOLD, 20));
        campoSegundoNumero.setLocation(200, 300);
        campoSegundoNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        janela.add(campoSegundoNumero);

        JButton botaoSomar = new JButton();
        botaoSomar.setText("+");
        botaoSomar.setBounds(85, 400, 75, 75);
        botaoSomar.setFont(new Font("", Font.BOLD, 60));
        botaoSomar.setBackground(new Color(110, 180, 230));
        botaoSomar.addActionListener(e -> setResultado(labelResultado, somar(campoPrimeiroNumero, campoSegundoNumero)));

        JButton botaoSubtrair = new JButton();
        botaoSubtrair.setText("-");
        botaoSubtrair.setBounds(170, 400, 75, 75);
        botaoSubtrair.setFont(new Font("", Font.BOLD, 60));
        botaoSubtrair.setBackground(new Color(110, 180, 230));
        botaoSubtrair.addActionListener(e -> setResultado(labelResultado, subtrair(campoPrimeiroNumero, campoSegundoNumero)));

        JButton botaoMultiplicar = new JButton();
        botaoMultiplicar.setText("*");
        botaoMultiplicar.setBounds(255, 400, 75, 75);
        botaoMultiplicar.setFont(new Font("", Font.BOLD, 60));
        botaoMultiplicar.setBackground(new Color(110, 180, 230));
        botaoMultiplicar.addActionListener(e -> setResultado(labelResultado, multiplicar(campoPrimeiroNumero, campoSegundoNumero)));

        JButton botaoDividir = new JButton();
        botaoDividir.setText("/");
        botaoDividir.setBounds(340, 400, 75, 75);
        botaoDividir.setFont(new Font("", Font.BOLD, 60));
        botaoDividir.setBackground(new Color(110, 180, 230));
        botaoDividir.addActionListener(e -> setResultado(labelResultado, dividir(campoPrimeiroNumero, campoSegundoNumero)));

        janela.add(labelResultado);
        janela.add(botaoSomar);
        janela.add(botaoSubtrair);
        janela.add(botaoMultiplicar);
        janela.add(botaoDividir);

        janela.setVisible(true);
    }

    private static long somar(JTextField campoPrimeiroNumero, JTextField campoSegundoNumero) {
        long primeiroNumero, segundoNumero;
        if (campoPrimeiroNumero.getText().isEmpty() || campoPrimeiroNumero.getText().isBlank()) {
            primeiroNumero = 0;
        } else {
            primeiroNumero = Long.parseLong(campoPrimeiroNumero.getText());
        }
        if (campoSegundoNumero.getText().isEmpty() || campoSegundoNumero.getText().isBlank()) {
            segundoNumero = 0;
        } else {
            segundoNumero = Long.parseLong(campoSegundoNumero.getText());
        }
        return primeiroNumero + segundoNumero;
    }

    private static long subtrair(JTextField campoPrimeiroNumero, JTextField campoSegundoNumero) {
        long primeiroNumero, segundoNumero;
        if (campoPrimeiroNumero.getText().isEmpty() || campoPrimeiroNumero.getText().isBlank()) {
            primeiroNumero = 0;
        } else {
            primeiroNumero = Long.parseLong(campoPrimeiroNumero.getText());
        }
        if (campoSegundoNumero.getText().isEmpty() || campoSegundoNumero.getText().isBlank()) {
            segundoNumero = 0;
        } else {
            segundoNumero = Long.parseLong(campoSegundoNumero.getText());
        }
        return primeiroNumero - segundoNumero;
    }

    private static long multiplicar(JTextField campoPrimeiroNumero, JTextField campoSegundoNumero) {
        long primeiroNumero, segundoNumero;
        if (campoPrimeiroNumero.getText().isEmpty() || campoPrimeiroNumero.getText().isBlank()) {
            primeiroNumero = 0;
        } else {
            primeiroNumero = Long.parseLong(campoPrimeiroNumero.getText());
        }
        if (campoSegundoNumero.getText().isEmpty() || campoSegundoNumero.getText().isBlank()) {
            segundoNumero = 0;
        } else {
            segundoNumero = Long.parseLong(campoSegundoNumero.getText());
        }
        return primeiroNumero * segundoNumero;
    }

    private static double dividir(JTextField campoPrimeiroNumero, JTextField campoSegundoNumero) {
        double primeiroNumero, segundoNumero;
        double resultado;
        if (campoPrimeiroNumero.getText().isEmpty() || campoPrimeiroNumero.getText().isBlank()) {
            primeiroNumero = 0;
        } else {
            primeiroNumero = Double.parseDouble(campoPrimeiroNumero.getText());
        }
        if (campoSegundoNumero.getText().isEmpty() || campoSegundoNumero.getText().isBlank()) {
            resultado = 0;
        } else {
            segundoNumero = Double.parseDouble(campoSegundoNumero.getText());
            resultado = primeiroNumero / segundoNumero;
        }
        return resultado;
    }

    private static void setResultado(JLabel labelResultado, long numero) {
        labelResultado.setText(String.valueOf(numero));
    }

    private static void setResultado(JLabel labelResultado, double numero) {
        labelResultado.setText(String.valueOf(numero));
    }
}