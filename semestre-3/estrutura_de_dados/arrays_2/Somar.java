/*
Marcos da Silva Schlick
marcosschlick.sl003@academico.ifsul.edu.br

1. Na classe Somar, faça um método que some todos os números pares de 1 a 1000. Também inclua um método para mostrar o resultado do cálculo;

somarPares() -> soma todos os números pares de 1 à 1000
imprimir() -> mostra o resultado do cálculo no terminal
 */

package estrutura_de_dados.arrays_2;

public class Somar {

    private int somarPares() {
        int resultado = 0;
        for(int i = 2; i <= 1000; i+=2) {
            resultado += i;
        }
        return resultado;
    }

    public void imprimir() {
        System.out.println("Classe Somar: soma de todos os números pares = " + somarPares());
    }
}
