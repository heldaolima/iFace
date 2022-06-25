package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.WrongPasswordException;

public class DestroyAccount extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Excluir conta");
        boolean result = false;
        try {
            result = iFace.excluirConta(logado);
        } catch (WrongPasswordException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        if (result) 
            logado = null;
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
