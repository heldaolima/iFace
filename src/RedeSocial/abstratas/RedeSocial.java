package src.RedeSocial.abstratas;

import src.RedeSocial.Logado;
import src.RedeSocial.Usuario;
import src.RedeSocial.customExceptions.ComunityCreatedException;
import src.RedeSocial.customExceptions.NoComunitiesException;
import src.RedeSocial.customExceptions.NoFriendsException;
import src.RedeSocial.customExceptions.NoRequestsException;
import src.RedeSocial.customExceptions.WrongPasswordException;

public interface RedeSocial {
    abstract boolean novaConta();
    abstract Usuario login();
    abstract boolean novoAtributo(Logado logado); 
    abstract boolean editarAtributo(Logado logado);
    abstract boolean enviarSolicitacao(Logado logado);
    abstract boolean responderSolicitacao(Logado logado) throws IndexOutOfBoundsException, NoRequestsException;
    abstract boolean enviarMensagem(Logado logado) throws IndexOutOfBoundsException, NoFriendsException;
    abstract boolean novaComunidade(Logado logado) throws ComunityCreatedException;
    abstract boolean virarMembroComunidade(Logado logado) throws NoComunitiesException;
    abstract void mostrarFeed(Logado logado);
    abstract boolean publicarNoFeed(Logado logado);
    abstract void resumoDaConta(Logado logado);
    abstract Logado logOut(Logado logado);
    abstract boolean excluirConta(Logado logado) throws WrongPasswordException;
}