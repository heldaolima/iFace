package src.RedeSocial.customExceptions;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException() {
        super("Nome inválido! Por favor, insira um nome válido: ");
    }
    public NomeInvalidoException(String msg) {
        super(msg);
    }
}