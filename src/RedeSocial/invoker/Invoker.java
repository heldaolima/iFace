package src.RedeSocial.invoker;

import java.util.ArrayList;
import src.RedeSocial.IFace;
import src.RedeSocial.command.Command;

public abstract class Invoker {
    public ArrayList<Command> comandos;

    public abstract void setCommands();
    
    public void call(Command comando, IFace iFace) {
        if (comando.execute(iFace))
            System.out.println(comando.successMsg());
        else
            System.out.println(comando.failureMsg());
    }

    public void call(int i, IFace iFace){
        this.call(comandos.get(i), iFace);
    } 
}