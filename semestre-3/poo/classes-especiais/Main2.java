public class Main2 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        System.out.println("Senha correta? " + usuario.autenticar("1234"));

        System.out.println("Senha correta? " + usuario.autenticar("abcd"));
    }
}
