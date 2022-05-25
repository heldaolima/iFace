package src.RedeSocial.customExceptions;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {
        super("Senha inválida.");
    }
    public InvalidPasswordException(String msg) {
        super(msg);
    }
}
