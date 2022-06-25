package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public abstract class Select {;
    public abstract boolean call(IFace iFace, Logado logado);
    public abstract String successMsg();
    public abstract String failureMsg();
    
    public void titulo(String str) {
        System.out.println("-=-=- "+str+" -=-=-");
    }
}
