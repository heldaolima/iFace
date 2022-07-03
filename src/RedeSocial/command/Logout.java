package src.RedeSocial.command;

import src.RedeSocial.IFace;

public class Logout extends Command{

    @Override
    public boolean execute(IFace iFace) {
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