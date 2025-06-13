public class Main3 {
    public static void main(String[] args) {
        Externa externa = new Externa();

        Externa.Interna interna = externa.new Interna();

        interna.exibirMensagem();
    }
}
