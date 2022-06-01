package src.RedeSocial.customExceptions;

public class NoAtributesException extends Exception {
    public NoAtributesException() {
        super("Nenhum atributo foi adicionado");
    }
}