package src.RedeSocial.customExceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Senha incorreta.");
    }
    
}
