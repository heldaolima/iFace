package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class Summary extends Select{

    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Resumo da conta");
        iFace.resumoDaConta(logado);
        return true;
    }

    @Override
    public String successMsg() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String failureMsg() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
