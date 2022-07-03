package src.RedeSocial.command;

import src.RedeSocial.IFace;

public class CreateAccount extends Command{
    
    @Override
    public boolean execute(IFace iFace) {
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
