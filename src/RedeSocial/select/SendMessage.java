package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.NoFriendsException;

public class SendMessage extends Select {

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Enviar mensagem");
        boolean result = false;
        try {
           result = iFace.enviarMensagem(logado);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Amigo não encontrado!\n");
        } catch (NoFriendsException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return "\nMensagem enviada\n";
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return "\nEnvio de mensagem cancelado\n";
    }
    
}
