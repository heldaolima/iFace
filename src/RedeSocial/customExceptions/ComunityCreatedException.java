package src.RedeSocial.customExceptions;

public class ComunityCreatedException extends Exception{
    public ComunityCreatedException() {
        super("A sua conta já tem uma comunidade criada");
    }
}
