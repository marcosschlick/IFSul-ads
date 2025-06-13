public class Usuario implements Autenticavel {
    @Override
    public boolean autenticar(String senha) {
        return senha.equals("1234");
    }
}
