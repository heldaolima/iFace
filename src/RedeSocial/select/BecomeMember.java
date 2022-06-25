package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.NoComunitiesException;

public class BecomeMember extends Select {

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Entrar em comunidade");
        boolean result = false;
        try {
            result = iFace.virarMembroComunidade(logado);                      
        } catch (NoComunitiesException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nComunidade não encontrada\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return "\nVocê virou membro da comunidade!\n";
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return "\nOperação cancelada\n";
    }
    
}
