package src.RedeSocial.customExceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Usuário não encontrado");
    }
}
