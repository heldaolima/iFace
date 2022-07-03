package src.RedeSocial.invoker;

import java.util.ArrayList;

import src.RedeSocial.select.CreateAccount;
import src.RedeSocial.select.LoginAccount;

public class UnLoggedIn extends Invoker {
    @Override
    public void setCommands() {
        this.comandos = new ArrayList<>();
        comandos.add(new CreateAccount());
        comandos.add(new LoginAccount());   
    }
    
} 