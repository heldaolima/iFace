package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class GetFeed extends Select{

    @Override
    public boolean call(IFace iFace) {
        titulo("Mostrar feed de notícias");
        iFace.mostrarFeed();
        return true;
    }

    @Override
    public String successMsg() {
        return "";
    }

    @Override
    public String failureMsg() {
        return "";
    }
    
}
