package src.RedeSocial.select;

import src.RedeSocial.IFace;

public class Summary extends Command{

    @Override
    public boolean execute(IFace iFace) {
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
