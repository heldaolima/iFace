package src.RedeSocial.command;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.ComunityCreatedException;

public class CreateComunity extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Criar comunidade");
        boolean result = false;
        try {
            result = iFace.novaComunidade();
        } catch(ComunityCreatedException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nComunidade criada\n";
    }

    @Override
    public String failureMsg() {
        return "\nCriação de comunidade cancelada\n";
    }
    
}
