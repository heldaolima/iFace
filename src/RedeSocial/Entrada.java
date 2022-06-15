package src.RedeSocial;

import src.RedeSocial.customExceptions.*;

public abstract class Entrada {
    protected String entrada;
    
    public Entrada() {
	}

	abstract void setEntrada(String entrada) 
            throws InvalidInputException; //verifica a validade de cada tipo de entrada

    public String getEntrada() {
        return this.entrada;
    }

    public boolean isEmpty(String entrada) { // esse método deve existir em todos
        if (entrada.equals("") || entrada == null || this.allSpaces(entrada))
            return true;
        return false;
    }

    public boolean allSpaces(String entrada) {
        char[] chars = entrada.toCharArray();
        int contSpaces = 0;
        for (char c: chars) {
            if (Character.isSpaceChar(c)) 
                contSpaces++;
        }
        return contSpaces == entrada.length();
    }
    
    public boolean allNumbers(String entrada) {
        char[] chars = entrada.toCharArray();
        int contDigits = 0;
        for (char c: chars) {
            if (Character.isDigit(c)) 
                contDigits++;
        }
        return contDigits == entrada.length();
    }

}
