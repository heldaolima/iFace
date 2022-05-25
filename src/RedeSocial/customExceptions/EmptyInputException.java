package src.RedeSocial.customExceptions;

public class EmptyInputException extends Exception{
    public EmptyInputException() {
        super("Entrada inválida.");
    }
}
