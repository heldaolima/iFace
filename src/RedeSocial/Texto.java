package src.RedeSocial;

import src.RedeSocial.customExceptions.InvalidInputException;

public class Texto extends Entrada{
    public Texto() {
        super();
    }

    @Override
    void setEntrada(String entrada) throws InvalidInputException {
        if (isEmpty(entrada))
            throw new InvalidInputException("Entrada inválida");
        this.entrada = entrada;
        
    }
    
}
