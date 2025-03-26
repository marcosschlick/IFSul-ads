/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

3. Na classe fatorial, usando métodos diferentes, calcule e imprima o fatorial de um número qualquer (até 20);

calcularFatorial() -> calcula o fatorial de 20
imprimir() -> mostra o resultado da operação de fatorial no console
 */

package semestre_3.estrutura_de_dados.arrays_2;

public class Fatorial {

    private long calcularFatorial() {
        long resultado = 1;
        for (int i = 20; i > 1; i--){
            resultado *= i;
        }
        return resultado;
    }


    public void imprimir() {
        System.out.println("Classe NumerosDivisiveis: quantidade de números divísiveis por 3 e 6 e não por 9 = " + calcularFatorial());
    }
}
