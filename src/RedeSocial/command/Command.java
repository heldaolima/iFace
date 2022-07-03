package src.RedeSocial.command;

import src.RedeSocial.IFace;

public abstract class Command {;
    public abstract boolean execute(IFace iFace);
    public abstract String successMsg();
    public abstract String failureMsg();
    
    public void titulo(String str) {
        System.out.println("-=-=- "+str+" -=-=-");
    }
}
