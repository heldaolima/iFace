package src.RedeSocial.abstratas;

import src.RedeSocial.Comunidade;
import src.usuario.Amigo;
import src.usuario.Atributo;
import src.usuario.Mensagem;
import src.usuario.Solicitacao;


public interface Perfil {
    //básico
    abstract boolean setNome(String nome);
    abstract boolean setLogin(String login);
    abstract String getNome();
    abstract String getLogin();
    abstract String getSenha();
    abstract void novoAtributo(Atributo novo);
    abstract boolean editarAtributo(int indice, boolean nome, String novo); //através do índice
    abstract int qtdAtributos();
    abstract void mostrarAtributos();

    //amigos
        //solicitacoes
            abstract int qtdSolicitacoes();
            abstract void mostrarSolicitacoes();
            abstract void removeSolicitacao(Solicitacao sol);
            abstract void recebeSolicitacao(Solicitacao sol);
        //amizades
            abstract void mostrarAmigos();
            abstract int qtdAmigos();
            abstract void adicionarAmigo(Amigo amigo);
            abstract void removerAmigo(Amigo amigo);
            abstract int verificarAmizade(String login);
            //mensagens
            abstract int qtdMensagens();
            abstract void mostrarMensagens();
            abstract void receberMensagem(String loginRemetente, Mensagem msg);
    //comunidades
            abstract boolean criarComunidade(Comunidade comunidade);
            abstract boolean apagarComundidade();
            abstract String comunidadeToString();
            abstract boolean temComunidade();
            abstract boolean eMembro(Comunidade comunidade);
            abstract boolean eDono(Comunidade comunidade);
            abstract void virarMembro(Comunidade comunidade);
            abstract void mostrarComunidadesMembro();
            abstract void removerComunidadeMembro(String nome);
        abstract void resumoDaConta();
}
