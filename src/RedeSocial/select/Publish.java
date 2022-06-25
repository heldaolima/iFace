package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class Publish extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Publicar no feed de notícias");
        return iFace.publicarNoFeed(logado); 
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return "\nPublicação disponível no feed\n";
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return "\nPublicação cancelada\n";
    }
    
}
