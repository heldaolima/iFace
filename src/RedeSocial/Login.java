package src.RedeSocial;

import src.RedeSocial.customExceptions.InvalidInputException;

public class Login extends Entrada{
    public Login() {
        super();
    }
    // ideia: Transformar todas as exceções de input invalido em apenas InvalidInputException
    @Override
    void setEntrada(String entrada) throws InvalidInputException {
        if (isEmpty(entrada))
            throw new InvalidInputException("Entrada inválida");
        else if (!isInvalidLogin(entrada))
            throw new InvalidInputException("O seu login não pode conter um dos símbolos inseridos");
        else if (allNumbers(entrada))
            throw new InvalidInputException("O seu login não pode ser apenas números");
        this.entrada = entrada;
    }

    public boolean isInvalidLogin(String entrada) {
        String symbols = "@#$%&*()'+,/:;<=>?[]^`{}";
        if (!entrada.equals("-1")) {
            char[] chars = entrada.toCharArray();
            for (char c: chars) {
                if (Character.isDigit(c) || symbols.contains(Character.toString(c)))
                    return true;
            }
        }
        return false;

    }
}
