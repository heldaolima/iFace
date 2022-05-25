package src.RedeSocial.customExceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("A senha inserida é inválida.");
    }
    
}
