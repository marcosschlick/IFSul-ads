/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

2. Na classe numerosDivisiveis, desenvolva um método para calcular a quantidade de numeros que são divisíveis por 3 e 6 e não são por 9, de 1 a 1000. Crie outro método para exibir o resultado;

numerosDivisiveis3e6() -> conta quantos números são divisíveis por 3 e 6 e não são por 9 de 1 a 1000
imprimir() -> mostra o resultado da contagem no terminal
 */

package estrutura_de_dados.arrays_2;

public class NumerosDivisiveis {

    private int numerosDivisiveis3e6() {
        int quantidade = 0;
        for (int i = 1; i <= 1000; i++){

            if(i % 3 == 0 && i % 6 == 0 && i % 9 != 0) {
                quantidade++;
            }
        }

        return quantidade;
    }

    public void imprimir() {
        System.out.println("Classe NumerosDivisiveis: quantidade de números divísiveis por 3 e 6 e não por 9 = " + numerosDivisiveis3e6());
    }
}
