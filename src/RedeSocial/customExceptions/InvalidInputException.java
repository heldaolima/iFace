package src.RedeSocial.customExceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Nome inválido.");
    }
    public InvalidInputException(String msg) {
        super(msg);
    }
}