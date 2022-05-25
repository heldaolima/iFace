package src.RedeSocial.customExceptions;

public class NoFriendsException extends Exception{
    public NoFriendsException() {
        super("Não há amigos disponíveis");
    }
}
