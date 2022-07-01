package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class Publish extends Select{

    @Override
    public boolean call(IFace iFace) {
        titulo("Publicar no feed de notícias");
        return iFace.publicarNoFeed(); 
    }

    @Override
    public String successMsg() {
        return "\nPublicação disponível no feed\n";
    }

    @Override
    public String failureMsg() {
        return "\nPublicação cancelada\n";
    }
    
}
