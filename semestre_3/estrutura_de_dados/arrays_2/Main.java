package semestre_3.estrutura_de_dados.arrays_2;

public class Main {
    public static void main(String[] args) {
        Somar classeSomar = new Somar();
        classeSomar.imprimir();

        NumerosDivisiveis classeNumerosDivisiveis = new NumerosDivisiveis();
        classeNumerosDivisiveis.imprimir();

        Fatorial classeFatorial = new Fatorial();
        classeFatorial.imprimir();

        NumerosPrimos classeNumerosPrimos = new NumerosPrimos();
        classeNumerosPrimos.imprimir();

        System.out.println();

        SequenciaFibonacci classeSequenciaFibonacci = new SequenciaFibonacci();
        classeSequenciaFibonacci.imprimir();

        int[] arrayEstatisticaBasica = {13, 423, 56, 76, 85, 999, 43 , 3 ,4, 5, 17, 1};
        EstatisticaBasica classeEstatisticaBasica = new EstatisticaBasica(arrayEstatisticaBasica);
        classeEstatisticaBasica.imprimir();

        int[] concatenar1NumerosConcatenados = {1, 2, 3, 4, 5};
        int[] concatenar2NumerosConcatenados = {6, 7, 8, 9, 10};
        int tamanhoNumerosConcatenados = concatenar1NumerosConcatenados.length + concatenar2NumerosConcatenados.length;
        int[] concatenadoNumerosConcatenados = new int[tamanhoNumerosConcatenados];
        NumerosConcatenados classeNumerosConcatenados = new NumerosConcatenados(concatenar1NumerosConcatenados, concatenar2NumerosConcatenados, concatenadoNumerosConcatenados);
        classeNumerosConcatenados.imprimir(concatenadoNumerosConcatenados);


    }
}
