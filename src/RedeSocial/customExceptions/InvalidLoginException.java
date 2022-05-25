package src.RedeSocial.customExceptions;

public class InvalidLoginException extends Exception{
    public InvalidLoginException() {
        super("Login inválido.");
    }

    public InvalidLoginException(String msg) {
        super(msg);
    }
}
