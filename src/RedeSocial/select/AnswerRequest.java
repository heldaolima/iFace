package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.NoRequestsException;

public class AnswerRequest extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Responder solicitação");
        boolean result = false;
        try {
            result = iFace.responderSolicitacao();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Usuário não encontrado!\n");
        } catch (NoRequestsException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nSolicitação respondida\n";
    }

    @Override
    public String failureMsg() {
        return "\nResposta cancelada\n";
    }
    
}
