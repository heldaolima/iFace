package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.ComunityCreatedException;

public class CreateComunity extends Select{

    @Override
    public boolean call(IFace iFace) {
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
