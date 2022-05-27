package src.RedeSocial.customExceptions;

public class NoAvaliableUsersException extends Exception{
    public NoAvaliableUsersException() {
        super("Não há usuários disponíveis");
    }
}
