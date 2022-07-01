package src.RedeSocial.select;

import src.RedeSocial.IFace;

public class GetFeed extends Command{

    @Override
    public boolean execute(IFace iFace) {
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
