package src.RedeSocial.invoker;

import java.util.ArrayList;

import src.RedeSocial.select.AnswerRequest;
import src.RedeSocial.select.BecomeMember;
import src.RedeSocial.select.CreateAtribute;
import src.RedeSocial.select.CreateComunity;
import src.RedeSocial.select.DestroyAccount;
import src.RedeSocial.select.EditAtribute;
import src.RedeSocial.select.GetFeed;
import src.RedeSocial.select.Logout;
import src.RedeSocial.select.Publish;
import src.RedeSocial.select.SendMessage;
import src.RedeSocial.select.SendRequest;
import src.RedeSocial.select.Summary;

public class LoggedIn extends Invoker{
    
    @Override
    public void setCommands() {
        this.comandos = new ArrayList<>();

        this.comandos.add(new CreateAtribute());
        this.comandos.add(new EditAtribute());
        this.comandos.add(new SendRequest());
        this.comandos.add(new AnswerRequest());
        this.comandos.add(new SendMessage());
        this.comandos.add(new CreateComunity());
        this.comandos.add(new BecomeMember());
        this.comandos.add(new GetFeed());
        this.comandos.add(new Publish());
        this.comandos.add(new Summary());
        this.comandos.add(new Logout());
        this.comandos.add(new DestroyAccount());
    }
}
