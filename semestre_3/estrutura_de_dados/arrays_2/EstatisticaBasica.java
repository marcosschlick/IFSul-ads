/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

6. Dentro da classe estatisticaBasica, crie um método que receba um vetor de inteiros no construtor da classe e imprima o menor, o maior e a média dos valores;

obterValores() -> utilizando o bubble sort eu ordeno array e faço um foreach para pegar o total, a definição de maior e menor é trivial
EstatisticaBasica() -> o construtor recebe um array e obtem todos os dados necessarios
imprimir() -> mostra o menor, o maior e a media do vetor no console
 */

package semestre_3.estrutura_de_dados.arrays_2;

public class EstatisticaBasica {
    private int menor = 0;
    private int maior = 0;
    private double media = 0;

    public EstatisticaBasica(int array[]) {
        obterValores(array);
    }

    private void obterValores(int array[]) {
        int aux = 0;
        double total = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if (array[i]>array[j]){
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        for(int each: array) {
            total += each;
        }

        this.menor = array[0];
        this.maior = array[array.length - 1];
        this.media = total / array.length;
    }

    public void imprimir() {
        System.out.println("Classe EstatisticaBasica: Menor valor do vetor: " + this.menor + ". Maior valor do vetor: " + this.maior + ". Média do vetor: " + this.media);
    }
}
