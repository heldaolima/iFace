package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.NoAvaliableUsersException;

public class SendRequest extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Enviar solicitação de amizade");
        boolean result = false;
        try {
            result = iFace.enviarSolicitacao();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Usuário não encontrado!");
        } catch (NoAvaliableUsersException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nSolicitação enviada!\n";
    }

    @Override
    public String failureMsg() {
        return "\nEnvio de solicitação cancelado\n";
    }
    
}
