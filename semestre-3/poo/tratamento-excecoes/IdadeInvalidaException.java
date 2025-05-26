public class IdadeInvalidaException extends Exception{
    public IdadeInvalidaException(){
        super("A idade não pode ser maior que 150 e não pode ser menor que 0.");
    }
}
