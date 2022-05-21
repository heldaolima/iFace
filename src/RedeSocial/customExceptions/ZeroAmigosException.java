package src.RedeSocial.customExceptions;

public class ZeroAmigosException extends Exception{
    public ZeroAmigosException() {
        super("Não há amigos disponíveis");
    }
}
