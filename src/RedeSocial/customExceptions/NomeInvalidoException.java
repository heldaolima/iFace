package src.RedeSocial.customExceptions;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException() {
        super("Nome inválido.");
    }
    public NomeInvalidoException(String msg) {
        super(msg);
    }
}