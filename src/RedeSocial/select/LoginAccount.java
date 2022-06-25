package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.UserNotFoundException;
import src.RedeSocial.customExceptions.WrongPasswordException;
import src.RedeSocial.Logado;

public class LoginAccount extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Entrar na conta");
        boolean result = false;
        try {
            result = iFace.login();
            // logado = new Logado(iFace.login());
        } catch (WrongPasswordException | UserNotFoundException e) {
            System.out.println("\n"+e.getMessage()+"\n");
        }

        return result;
    }

    @Override
    public String successMsg() {
        return "\nLogado com sucesso!\n";
    }

    @Override
    public String failureMsg() {
        return "\nLogin ou senha inválidos\n";
    }
    
}