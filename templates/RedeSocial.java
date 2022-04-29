package templates;

import main.Atributo;
import main.Usuario;

public interface RedeSocial {
    abstract boolean novaConta();
    abstract boolean login();
    abstract boolean novoAtributo(); 
    abstract boolean editarAtributo();
    abstract boolean enviarSolicitacao();
    abstract boolean responderSolicitacao();
    abstract boolean enviarMensagem();
    abstract boolean responderMensagem();
    abstract boolean novaComunidade();
    abstract boolean virarMembroComunidade();
    abstract boolean publicarNoFeed();
    abstract void mostrarFeed();
    abstract Usuario logOut();
}