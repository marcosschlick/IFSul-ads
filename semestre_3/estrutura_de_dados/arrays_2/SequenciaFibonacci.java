/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

5. Na classe sequenciaFibonacci, crie um vetor de inteiros contendo os dez primeiros números da sequência de Fibonacci. Após, imprima esses numeros (um em cada linha) usando para isso um outro método;

obterSequenciaFibonacci() -> preenche um array com os 10 primeiros números da sequência de Fibonacci
imprimir() -> mostra os primeiros 10 números da sequência de Fibonacci em cada linha
 */

package semestre_3.estrutura_de_dados.arrays_2;

public class SequenciaFibonacci {

    private void obterSequenciaFibonacci (int array[]) {
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < 10; i++){
            int num = array[i - 2] + array[i - 1];
            array[i] = num;
        }
    }

    public void imprimir() {
        int[] array = new int[10];
        obterSequenciaFibonacci(array);
        System.out.println("Classe SequenciaFibonacci: primeiros 10 números da sequência Fibonacci:");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + "º número da sequência Fibonacci = " + array[i]);
        }
    }

}
