/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

7.
Dentro da classe numerosConcatenados, escreva um método que receba dois vetores compostos por números inteiros como parâmetros e retorne um novo vetor que seja a concatenação deles. Em um outro método, faça a exibição do resultado
Exemplo de entrada: [1,2,3,4,5], [6,7,8,9,10]
Exemplo de saída: [1,2,3,4,5,6,7,8,9,10]

NumerosConcatenados() -> o construtor chama o meotodo concatenarVetores()
concatenarVetores() -> recebe 3 arrays e concatena o 1o e o 2o no 3o array
imprimir() -> mostra o 3o array
 */

package estrutura_de_dados.arrays_2;

public class NumerosConcatenados {

    public NumerosConcatenados(int[] array1, int[] array2, int[] array) {
        concatenarVetores(array1, array2, array);
    }


    private void concatenarVetores(int array1[], int array2[], int array[]) {

        int index = 0;

        for (int i = 0; i < array1.length; i++) {
            array[index] = array1[i];
            index++;
        }
        for (int i = 0; i < array1.length; i++) {
            array[index] = array2[i];
            index++;
        }
    }

    public void imprimir(int array[]) {
        System.out.print("Classe NumerosConcatenados: array concatenado [ ");
        for(int each: array) {
            System.out.print(each + ", ");
        }
        System.out.print("]");
    }
}
