package semestre_3.estrutura_de_dados;

import java.util.Random;

public class Primos {
    public static void main(String[] args) {
        int[] primos = new int[10000];
        obterPrimos(primos);

        for (int i = 0; i < primos.length; i++) {
            System.out.println((i + 1)+ ": " + primos[i]);
        }
        int[] novoArray = new int[25];

        preencherVetor(novoArray, primos);

        for (int i = 0; i < novoArray.length; i++) {
            System.out.println((i + 1)+ ": " + novoArray[i]);
        }

    }
    private static void obterPrimos(int[] array) {
        array[0] = 2;
        int proximoNumero = 3;
        for(int i = 1; i < 10000; i++){
                while (array[i] == 0) {
                    boolean isPrimo= true;
                    for (int j = 2; j < proximoNumero; j++) {
                        if (proximoNumero % j == 0) {
                            isPrimo = false;
                            break;
                        }
                    }
                    if (isPrimo) {
                        array[i] = proximoNumero;
                    }
                    proximoNumero++;
                }
            proximoNumero = array[i] + 2;
        }
    }

    private static int obterIndice() {
        Random random = new Random();
        int num = random.nextInt(1000);
        return num;
    }

    private static void preencherVetor(int[] array,  int[] primos) {
        for (int i = 0; i < 25; i++) {
            array[i] = primos[obterIndice()];
        }
    }
}
