package src.RedeSocial.customExceptions;

public class SenhaInvalidaException extends Exception{
    public SenhaInvalidaException() {
        super("Senha inválida.");
    }
    public SenhaInvalidaException(String msg) {
        super(msg);
    }
}
