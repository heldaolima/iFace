package src.RedeSocial.command;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.WrongPasswordException;

public class DestroyAccount extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Excluir conta");
        boolean result = false;
        try {
            result = iFace.excluirConta();
        } catch (WrongPasswordException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nConta excluída\n";
    }

    @Override
    public String failureMsg() {
        return "\nExclusão de conta cancelada\n";
    }
    
}
