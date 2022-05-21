package src.RedeSocial.customExceptions;

public class ZeroComunidadesException extends Exception{
    public ZeroComunidadesException() {
        super("Não há comunidades disponíveis.");
    }
}
