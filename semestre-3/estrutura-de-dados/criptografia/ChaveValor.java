import java.util.ArrayList;

public class ChaveValor {
    private String chave;
    private Object valor;
    private ArrayList<ChaveValor> chavesValores = new ArrayList<>();

    public ChaveValor(String chave, Object valor){
        this.chave = chave;
        this.valor = valor;
    }

    public ChaveValor() {
        chavesValores.add(new ChaveValor("A", 1));
        chavesValores.add(new ChaveValor("B", 2));
        chavesValores.add(new ChaveValor("C", 3));
        chavesValores.add(new ChaveValor("D", 4));
        chavesValores.add(new ChaveValor("E", 5));
        chavesValores.add(new ChaveValor("F", 6));
        chavesValores.add(new ChaveValor("G", 7));
        chavesValores.add(new ChaveValor("H", 8));
        chavesValores.add(new ChaveValor("I", 9));
        chavesValores.add(new ChaveValor("J", 10));
        chavesValores.add(new ChaveValor("K", 11));
        chavesValores.add(new ChaveValor("L", 12));
        chavesValores.add(new ChaveValor("M", 13));
        chavesValores.add(new ChaveValor("N", 14));
        chavesValores.add(new ChaveValor("O", 15));
        chavesValores.add(new ChaveValor("P", 16));
        chavesValores.add(new ChaveValor("Q", 17));
        chavesValores.add(new ChaveValor("R", 18));
        chavesValores.add(new ChaveValor("S", 19));
        chavesValores.add(new ChaveValor("T", 20));
        chavesValores.add(new ChaveValor("U", 21));
        chavesValores.add(new ChaveValor("V", 22));
        chavesValores.add(new ChaveValor("W", 23));
        chavesValores.add(new ChaveValor("X", 24));
        chavesValores.add(new ChaveValor("Y", 25));
        chavesValores.add(new ChaveValor("Z", 26));
    }

    public String getChaveByValor(Object valorBuscado) {
        for (ChaveValor par : chavesValores) {
            if (par.valor.equals(valorBuscado)) {
                return par.chave;
            }
        }
        return valorBuscado.toString();
    }

    public String getValorByChave(String chaveBuscada) {
        for (ChaveValor par : chavesValores) {
            if (par.chave.equals(chaveBuscada)) {
                return par.valor.toString();
            }
        }
        return null;
    }

    public String getChave() {
        return chave;
    }

    public Object getValor() {
        return valor;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
}
