import java.util.ArrayList;
import java.util.Collections;

public class Encriptador {
    private String fraseParaEncriptar;
    private String chaveDeEncriptacao;
    ChaveValor chaveValor = new ChaveValor();
    ArrayList<ChaveValor> novasChavesValores = new ArrayList<>();

    public Encriptador(String fraseParaEncriptar, String chaveDeEncriptacao){
        this.fraseParaEncriptar = fraseParaEncriptar;
        this.chaveDeEncriptacao = chaveDeEncriptacao;
    }

    private static String formatDouble(double value) {
        double multipliedValue = value * 100;
        long truncatedValue = (long) multipliedValue;
        return String.valueOf(truncatedValue);
    }

    public String passo1() {
        int tamanhoFrase = fraseParaEncriptar.length();
        StringBuilder novaFrase = new StringBuilder();

        int aux = 0;
        for (int i = 0; i < tamanhoFrase; i++) {
            String currentChar = String.valueOf(fraseParaEncriptar.charAt(i));
            String valorPossivel = chaveValor.getValorByChave(currentChar);

            if(valorPossivel == null){
                novaFrase.append(currentChar);
                novasChavesValores.add(new ChaveValor("ESPECIAL", currentChar));
            } else {
                String chave = String.valueOf(chaveDeEncriptacao.charAt(aux));
                Integer valor = Integer.parseInt(chaveValor.getValorByChave(currentChar));
                novaFrase.append(chave);
                novaFrase.append(valor);
                novasChavesValores.add(new ChaveValor(chave, valor));
                aux = (aux + 1) % chaveDeEncriptacao.length();
            }
        }
        fraseParaEncriptar = novaFrase.toString();
        return novaFrase.toString();
    }

    public String passo2() {
        Collections.reverse(novasChavesValores);
        int tamanhoArray = novasChavesValores.size();
        StringBuilder novaFrase = new StringBuilder();

        for (int i = 0; i < tamanhoArray; i++) {
            if("ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                novaFrase.append(novasChavesValores.get(i).getValor());
            } else {
                novaFrase.append(novasChavesValores.get(i).getChave());
                novaFrase.append(novasChavesValores.get(i).getValor());
            }
        }
        fraseParaEncriptar = novaFrase.toString();
        return novaFrase.toString();
    }

    public String passo3() {
        int tamanhoArray = novasChavesValores.size();
        int quantidadeCaracteres = 0;
        StringBuilder novaFrase = new StringBuilder();

        for (int i = 0; i < tamanhoArray; i++) {
            if(!"ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                quantidadeCaracteres++;
            }
        }

        for (int i = 0; i < tamanhoArray; i++) {
            if("ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                novaFrase.append(novasChavesValores.get(i).getValor());
            } else {
                String currentValor = String.valueOf(novasChavesValores.get(i).getValor());
                int numero = Integer.parseInt(currentValor);
                novasChavesValores.get(i).setValor(numero * quantidadeCaracteres);
                novaFrase.append(novasChavesValores.get(i).getChave());
                novaFrase.append(novasChavesValores.get(i).getValor());
            }
        }

        return novaFrase.toString();
    }

    public String passo4() {
        int tamanhoChaveDeEncriptacao = chaveDeEncriptacao.length();
        int tamanhoArray = novasChavesValores.size();
        StringBuilder novaFrase = new StringBuilder();

        for (int i = 0; i < tamanhoArray; i++) {
            if("ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                novaFrase.append(novasChavesValores.get(i).getValor());
            } else {
                String currentValor = String.valueOf(novasChavesValores.get(i).getValor());
                int numero = Integer.parseInt(currentValor);
                novasChavesValores.get(i).setValor(formatDouble((double) numero / tamanhoChaveDeEncriptacao));
                novaFrase.append(novasChavesValores.get(i).getChave());
                novaFrase.append(novasChavesValores.get(i).getValor());
            }
        }
        return novaFrase.toString();
    }

    public String desencriptar() {
        StringBuilder novaFrase = new StringBuilder();
        int tamanhoChaveDeEncriptacao = chaveDeEncriptacao.length();
        int tamanhoArray = novasChavesValores.size();
        int quantidadeCaracteres = 0;

        for (int i = 0; i < tamanhoArray; i++) {
            if(!"ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                quantidadeCaracteres++;
            }
        }

        for (int i = 0; i < tamanhoArray; i++) {
            if(!"ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                String currentValor = String.valueOf(novasChavesValores.get(i).getValor());
                int numero = Integer.parseInt(currentValor);
                novasChavesValores.get(i).setValor((((int) numero / 100) * tamanhoChaveDeEncriptacao) / quantidadeCaracteres);
            }
        }

        Collections.reverse(novasChavesValores);

        for (int i = 0; i < tamanhoArray; i++) {

            if("ESPECIAL".equals(novasChavesValores.get(i).getChave())){
                novaFrase.append(novasChavesValores.get(i).getValor());
            }else {
                novaFrase.append(chaveValor.getChaveByValor(novasChavesValores.get(i).getValor()));
            }
        }
        return novaFrase.toString();
    }
}