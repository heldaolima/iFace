package src.RedeSocial.command;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.UserNotFoundException;
import src.RedeSocial.customExceptions.WrongPasswordException;

public class LoginAccount extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Entrar na conta");
        boolean result = false;
        try {
            result = iFace.login();
        } catch (WrongPasswordException | UserNotFoundException e) {
            System.out.println(e.getMessage());
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
