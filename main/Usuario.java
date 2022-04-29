package main;

import java.util.ArrayList;

import templates.Perfil;

public class Usuario implements Perfil {

    private String nome;
    private String login;
    private String senha;
    protected ArrayList<Amigo> amigos = new ArrayList<Amigo>();
    protected ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
    private Comunidade comunidade = null;
    private ArrayList<String> comunidadesMembro;
    private ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
    protected ArrayList<Atributo> atributos = new ArrayList<Atributo>();
    //veja se consegue adicionar um indice; mas talvez não seja necessário, 
    //porque tem como pegar o cara a partir do que ele é no arrayList

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String dadosBasicos() {
        return this.login + ": " + this.nome;
    }
    
    @Override
    public boolean setNome(String nome) {
        if (nome == "" || nome == null)
            return false;
        this.nome = nome;
        return true;
    }

    @Override
    public boolean setLogin(String login) {
        if (login == "" || login == null)
            return false;
        this.login = login;
        return true;
    }


    @Override
    public String getNome() {        
        return this.nome;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    @Override
    public void novoAtributo(Atributo novo) {
        this.atributos.add(novo);
    }

    @Override
    public void mostrarAtributos() {
        int i = 1;
        for (Atributo a: atributos) {
            System.out.println("["+i+"]"+a.toString());
            i++;
        }
    }

    @Override
    public boolean editarAtributo(int indice, boolean nome, String novo) {
        if (novo == "" || novo == null) 
            return false;

        else if (nome) 
            atributos.get(indice).setNome(novo);
        else 
            atributos.get(indice).setDescricao(novo);
        return true;
    }

    @Override
    public int qtdAtributos() {
        return atributos.size();
    }

    @Override
    public int qtdSolicitacoes() {
        return solicitacoes.size();
    }

    @Override
    public void mostrarSolicitacoes() {
        int i = 1;
        for (Solicitacao sol : solicitacoes) {
            System.out.println("["+i+"] "+sol.toString());
            i++;            
        }
    }

    @Override
    public void removeSolicitacao(Solicitacao sol) {
        solicitacoes.remove(sol);
    }

    @Override
    public void recebeSolicitacao(Solicitacao sol) {
        solicitacoes.add(sol);
    }


    @Override
    public void mostrarAmigos() {
        int i = 1;
        for (Amigo amigo : amigos) {
            System.out.println("["+i+"] "+amigo.toString());
            i++;
        }
    }

    @Override
    public int qtdAmigos() {
        return amigos.size();
    }

    @Override
    public void adicionarAmigo(Amigo amigo) {
        amigos.add(amigo);
    }

    @Override
    public void removerAmigo(String login) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int verificarAmizade(String login) {
        for (int i = 0; i < amigos.size(); i++) {
            if (amigos.get(i).getLogin().equals(login))
                return i;
        }
        return -1;
    }

    @Override
    public int qtdMensagens() {
        return mensagens.size();
    }

    @Override
    public void mostrarMensagens() {
        for(Mensagem msg : mensagens) {
            System.out.println(msg.toString());
        }
    }

    @Override
    public boolean enviarMensagem(Mensagem msg) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void novaMensagem(Mensagem msg) {
        mensagens.add(msg);
    }

    @Override
    public boolean criarComunidade(Comunidade nova) {
        if (nova == null)
            return false;

        comunidade = nova;
        return true;
    }

    @Override
    public String comunidadeToString() {
        return comunidade.toString();
    }

    @Override
    public boolean temComunidade() {
        if (comunidade == null)
            return false;
        return true;
    }

    @Override
    public boolean eMembro(Comunidade comunidade) {
        return false;
    }

    @Override
    public boolean eDono(Comunidade comunidade) {
        if (comunidade == this.comunidade) 
            return true;
        return false;
    }

    @Override
    public void virarMembro(Comunidade comunidade) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mostrarComunidadesMembro() {
        // TODO Auto-generated method stub
        
    }

    public Solicitacao getSolicitacao(int i ) {
        return solicitacoes.get(i);
    }

    public int verificarSolicitacao(String login) {
        int i = 0;
        for (Solicitacao sol: solicitacoes) {
            if (sol.getLogin().equals(login)) 
                return i;
            i++;
        }
        return -1;
    }

    public Amigo getAmigo(int i) {
        return amigos.get(i);
    }
}
