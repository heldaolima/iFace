package src.RedeSocial.invoker;

import java.util.ArrayList;

import src.RedeSocial.command.CreateAccount;
import src.RedeSocial.command.LoginAccount;

public class UnLoggedIn extends Invoker {
    @Override
    public void setCommands() {
        this.comandos = new ArrayList<>();
        comandos.add(new CreateAccount());
        comandos.add(new LoginAccount());   
    }
    
} 