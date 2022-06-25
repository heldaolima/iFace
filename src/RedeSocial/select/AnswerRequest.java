package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.NoRequestsException;

public class AnswerRequest extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Responder solicitação");
        boolean result = false;
        try {
            result = iFace.responderSolicitacao(logado);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Usuário não encontrado!\n");
        } catch (NoRequestsException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return "\nSolicitação respondida\n";
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return "\nResposta cancelada\n";
    }
    
}
