package src.RedeSocial.select;

import src.RedeSocial.IFace;

public abstract class Select {;
    public abstract boolean call(IFace iFace);
    public abstract String successMsg();
    public abstract String failureMsg();
    
    public void titulo(String str) {
        System.out.println("-=-=- "+str+" -=-=-");
    }
}
