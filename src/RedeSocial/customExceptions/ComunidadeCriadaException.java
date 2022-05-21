package src.RedeSocial.customExceptions;

public class ComunidadeCriadaException extends Exception{
    public ComunidadeCriadaException() {
        super("A sua conta já tem uma comunidade criada");
    }
}
