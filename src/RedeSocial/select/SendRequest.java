package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.NoAvaliableUsersException;

public class SendRequest extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Enviar solicitação de amizade");
        boolean result = false;
        try {
            result = iFace.enviarSolicitacao(logado);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Usuário não encontrado!");
        } catch (NoAvaliableUsersException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return "\nSolicitação enviada!\n";
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return "\nEnvio de solicitação cancelado\n";
    }
    
}
