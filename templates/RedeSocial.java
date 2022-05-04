package templates;

// import main.Atributo;
import main.Usuario;
import main.Logado;

public interface RedeSocial {
    abstract boolean novaConta();
    abstract Usuario login();
    abstract boolean novoAtributo(Logado logado); 
    abstract boolean editarAtributo(Logado logado);
    abstract boolean enviarSolicitacao(Logado logado);
    abstract boolean responderSolicitacao(Logado logado);
    abstract boolean enviarMensagem(Logado logado);
    abstract boolean novaComunidade(Logado logado);
    abstract boolean virarMembroComunidade(Logado logado);
    abstract void mostrarFeed(Logado logado);
    abstract boolean publicarNoFeed(Logado logado);
    abstract void resumoDaConta(Logado logado);
    abstract Logado logOut(Logado logado);
    abstract boolean excluirConta(Logado logado);
}