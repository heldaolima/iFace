package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class Logout extends Select{

    @Override
    public boolean call(IFace iFace) {
        System.out.println("\nSaindo...\n");
        iFace.logOut();
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