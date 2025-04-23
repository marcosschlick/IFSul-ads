/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

4. Na classe numerosPrimos, crie um método que calcule e grave em um vetor os quinze primeiros números primos. Depois, em outro método, imprima os valores encontrados;

obterPrimos() -> preenche um array com os 15 primeiros números primos
imprimir() -> mostra os primeiros 15 números primos no console
 */

public class NumerosPrimos {

    private void obterPrimos(int array[]) {
        array[0] = 2;
        int proximoNumero = 3;
        for(int i = 1; i < array.length; i++){
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

    public void imprimir() {
        int[] array = new int[15];
        obterPrimos(array);

        System.out.print("Classe NumerosPrimos: primeiros 15 números primos = ");

        for (int primo: array){
            System.out.print(primo + " ");
        }
    }
}
