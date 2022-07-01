package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class CreateAtribute extends Select{

    @Override
    public boolean call(IFace iFace) {
        titulo("Criar atributo");
        return iFace.novoAtributo(); 
    }

    @Override
    public String successMsg() {
        return "\nAtributo adicionado\n";
    }

    @Override
    public String failureMsg() {
        return "\nCriação de atributo cancelada";
    }
    
}
