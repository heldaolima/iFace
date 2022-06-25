package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class GetFeed extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Mostrar feed de notícias");
        iFace.mostrarFeed(logado);
        return true;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
