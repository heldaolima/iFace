package src.RedeSocial.command;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.NoComunitiesException;

public class BecomeMember extends Command {

    @Override
    public boolean execute(IFace iFace) {
        titulo("Entrar em comunidade");
        boolean result = false;
        try {
            result = iFace.virarMembroComunidade();                      
        } catch (NoComunitiesException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nComunidade não encontrada\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nVocê virou membro da comunidade!\n";
    }

    @Override
    public String failureMsg() {
        return "\nOperação cancelada\n";
    }
    
}
