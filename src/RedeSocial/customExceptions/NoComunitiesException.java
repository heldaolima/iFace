package src.RedeSocial.customExceptions;

public class NoComunitiesException extends Exception{
    public NoComunitiesException() {
        super("Não há comunidades disponíveis.");
    }
}
