package src.RedeSocial.customExceptions;

public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException() {
        super("Nome inválido.");
    }
    public EntradaInvalidaException(String msg) {
        super(msg);
    }
}