package src.RedeSocial.customExceptions;

public class LoginInvalidoException extends Exception{
    public LoginInvalidoException() {
        super("Login inválido.");
    }

    public LoginInvalidoException(String msg) {
        super(msg);
    }
}
