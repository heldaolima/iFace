package src.RedeSocial.abstratas;

import src.RedeSocial.Logado;
import src.RedeSocial.Usuario;
import src.RedeSocial.customExceptions.ComunidadeCriadaException;
import src.RedeSocial.customExceptions.ZeroComunidadesException;
import src.RedeSocial.customExceptions.ZeroAmigosException;

public interface RedeSocial {
    abstract boolean novaConta();
    abstract Usuario login();
    abstract boolean novoAtributo(Logado logado); 
    abstract boolean editarAtributo(Logado logado);
    abstract boolean enviarSolicitacao(Logado logado);
    abstract boolean responderSolicitacao(Logado logado);
    abstract boolean enviarMensagem(Logado logado) throws IndexOutOfBoundsException, ZeroAmigosException;
    abstract boolean novaComunidade(Logado logado) throws ComunidadeCriadaException;
    abstract boolean virarMembroComunidade(Logado logado) throws ZeroComunidadesException;
    abstract void mostrarFeed(Logado logado);
    abstract boolean publicarNoFeed(Logado logado);
    abstract void resumoDaConta(Logado logado);
    abstract Logado logOut(Logado logado);
    abstract boolean excluirConta(Logado logado);
}