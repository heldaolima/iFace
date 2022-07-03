package src.RedeSocial.command;

import src.RedeSocial.IFace;
import src.RedeSocial.customExceptions.NoAtributesException;

public class EditAtribute extends Command{

    @Override
    public boolean execute(IFace iFace) {
        titulo("Editar atributo");
        boolean result = false;
        try {
            result = iFace.editarAtributo();
        } catch(IndexOutOfBoundsException e) {
            System.err.println("\nErro! Atributo não encontrado\n");
        } catch(NoAtributesException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String successMsg() {
        return "\nEdição concluída\n";
    }

    @Override
    public String failureMsg() {
        return "\nEdição cancelada\n";
    }
    
}
