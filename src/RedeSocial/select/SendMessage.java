package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.NoFriendsException;

public class SendMessage extends Select {

    @Override
    public boolean call(IFace iFace) {
        titulo("Enviar mensagem");
        boolean result = false;
        try {
           result = iFace.enviarMensagem();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("\nErro! Amigo não encontrado!\n");
        } catch (NoFriendsException e) {
            System.err.println("\n"+e.getMessage()+"\n");
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nMensagem enviada\n";
    }

    @Override
    public String failureMsg() {
        return "\nEnvio de mensagem cancelado\n";
    }
    
}
