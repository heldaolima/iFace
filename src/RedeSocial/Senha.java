package src.RedeSocial;

import src.RedeSocial.customExceptions.InvalidInputException;

public class Senha extends Entrada{
    public Senha() {
        super();
    }

    @Override
    void setEntrada(String entrada) throws InvalidInputException {
        if (isEmpty(entrada))
            throw new InvalidInputException("Entrada inválida");
        else if (entrada.length() < 6)
            throw new InvalidInputException("A senha deve ter pelo menos 6 caracteres");
        else if (entrada.contains(" "))
            throw new InvalidInputException("A senha não pode conter espaços");
        this.entrada = entrada;
    }

}
