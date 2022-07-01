package src.RedeSocial.select;

import src.RedeSocial.IFace;

public class CreateAtribute extends Command{

    @Override
    public boolean execute(IFace iFace) {
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
