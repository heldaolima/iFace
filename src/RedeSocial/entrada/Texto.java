package src.RedeSocial.entrada;

import src.RedeSocial.customExceptions.InvalidInputException;

public class Texto extends Entrada{
    public Texto() {
        super();
    }

    @Override
    public void setEntrada(String entrada) throws InvalidInputException {
        if (isEmpty(entrada))
            throw new InvalidInputException("Entrada inválida");
        this.entrada = entrada;
        
    }
    
}
