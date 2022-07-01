package src.RedeSocial.select;

import src.RedeSocial.IFace;

public class Publish extends Command{

    @Override
    public boolean execute(IFace iFace) {
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
