package templates;

import main.Atributo;
import main.Comunidade;
import main.Mensagem;
import main.Solicitacao;
import main.Amigo;


public interface Perfil {
    //básico
    abstract boolean setNome(String nome);
    abstract boolean setLogin(String login);
    // abstract boolean setSenha(String senha); // não se pode editar a senha
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
            // abstract boolean respoderSolicitacao(Solicitacao sol, int i); //acho que isso é coisa do iFace também
        //amizades
            abstract void mostrarAmigos();
            abstract int qtdAmigos();
            abstract void adicionarAmigo(Amigo amigo);
            abstract void removerAmigo(String login);
            abstract int verificarAmizade(String login);
            //mensagens
            abstract int qtdMensagens();
            abstract void mostrarMensagens();
            abstract boolean enviarMensagem(Mensagem msg);
            abstract void novaMensagem(Mensagem msg); //essa deve somente colocar a nova lá dentro; o processo que, faz é o iFace
    //comunidades
            abstract boolean criarComunidade(Comunidade nova);
            abstract String comunidadeToString();
            abstract boolean temComunidade();
            abstract boolean eMembro(Comunidade comunidade);
            abstract boolean eDono(Comunidade comunidade);
            abstract void virarMembro(Comunidade comunidade);
            abstract void mostrarComunidadesMembro();
}
