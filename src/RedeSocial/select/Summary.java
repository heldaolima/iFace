package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class Summary extends Select{

    @Override
    public boolean call(IFace iFace) {
        titulo("Resumo da conta");
        iFace.resumoDaConta();
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
