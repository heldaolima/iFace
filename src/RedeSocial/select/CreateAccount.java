package src.RedeSocial.select;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;

public class CreateAccount extends Select{
    
    @Override
    public boolean call(IFace iFace, Logado logado) {
        titulo("Criar conta");
        return iFace.novaConta();
    }

    @Override
    public String successMsg() {
        return "\nConta criada com sucesso\n";
    }

    @Override
    public String failureMsg() {
        return "\n\nCriação de conta cancelada\n";
    }
}
