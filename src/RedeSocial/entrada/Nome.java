package src.RedeSocial.entrada;


import src.RedeSocial.customExceptions.InvalidInputException;

public class Nome extends Entrada{
    public Nome(){
        super();
    }

    @Override
    public void setEntrada(String entrada) throws InvalidInputException{
        if (isEmpty(entrada))
            throw new InvalidInputException("Entrada inválida");
        else if (containsSymbol(entrada))
            throw new InvalidInputException("A entrada não pode conter números nem símbolos");
        else
            this.entrada = entrada;
    }

    public boolean containsSymbol(String entrada) {
        String symbols = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
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
