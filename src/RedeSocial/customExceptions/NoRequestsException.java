package src.RedeSocial.customExceptions;

public class NoRequestsException extends Exception{
    public NoRequestsException() {
        super("Não há solicitações de amizade");
    }
}
