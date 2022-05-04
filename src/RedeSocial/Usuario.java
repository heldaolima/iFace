package src.RedeSocial;

import java.util.ArrayList;

import src.RedeSocial.abstratas.Perfil;
import src.usuario.Amigo;
import src.usuario.Atributo;
import src.usuario.Mensagem;
import src.usuario.Solicitacao;

public class Usuario implements Perfil {

    private String nome, login, senha;
    protected ArrayList<Amigo> amigos = new ArrayList<Amigo>();
    protected ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
    protected Comunidade comunidade = null;
    protected ArrayList<String> comunidadesMembro = new ArrayList<String>();
    protected ArrayList<Atributo> atributos = new ArrayList<Atributo>();
    
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String dadosBasicos() {
        return "Login: @"+this.login + "| Nome: " + this.nome;
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
            System.out.println("["+i+"] "+a.toString());
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
    public int verificarAmizade(String login) {
        for (int i = 0; i < amigos.size(); i++) {
            if (amigos.get(i).getLogin().equals(login))
                return i;
        }
        return -1;
    }

    @Override
    public int qtdMensagens() {
        int cont = 0;
        for (Amigo a: amigos) {
            cont += a.qtdMensagens();
        }
        return cont;
    }

    @Override
    public void mostrarMensagens() {
        int i = 1;
        for (Amigo a: amigos) {
            System.out.println("["+i+"] "+a.getLogin()+": ");
            a.mostrarMensagens();
            System.out.println();
        }
    }

    @Override
    public void receberMensagem(String loginRemetente, Mensagem msg) {
        for (Amigo a: amigos) {
            if (a.getLogin().equals(loginRemetente)) {
                a.novaMensagem(msg);
            }
        }
    }

    @Override
    public boolean criarComunidade(Comunidade nova) {
        if (nova == null)
            return false;

        this.comunidade = nova;
        return true;
    }

    @Override
    public boolean apagarComundidade() {
        if (comunidade == null)
            return false;

        comunidade = null;
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
        if (comunidadesMembro.contains(comunidade.getNome())) 
            return true;
        else 
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
        comunidadesMembro.add(comunidade.getNome());
        
    }
    
    @Override
    public void mostrarComunidadesMembro() {
        for (String nome: comunidadesMembro) {
            System.out.println(nome);
        }   
    }
    
    @Override
    public void removerAmigo(Amigo amigo) {
        this.amigos.remove(amigo);
    }

    @Override
    public void removerComunidadeMembro(String nome) {
        comunidadesMembro.remove(nome);
    }

    
    @Override
    public void resumoDaConta() {
        System.out.println(this.dadosBasicos());
        System.out.println("-------------------");
        System.out.println("Você tem "+this.qtdAtributos()+" atributos:");
        this.mostrarAtributos();
        System.out.println("-------------------");
        
        if (this.temComunidade()) {
            System.out.println("Comunidade criada: ");
            System.out.println(this.comunidadeToString());
        }
        else
        System.out.println("Você não criou uma comunidade\n");
        System.out.println("-------------------");
        
        System.out.println("Você é membro de "+this.qtdComunidadesMembro()+" comunidades:");
        this.mostrarComunidadesMembro();
        System.out.println("-------------------");
        
        System.out.println("Você tem "+this.qtdAmigos()+" amigos: ");
        this.mostrarAmigos();
        System.out.println("-------------------");
        
        if (this.qtdMensagens() > 0) {
            System.out.println("Suas mensagens: ");
            this.mostrarMensagens();
        }
        else
        System.out.println("Você não tem mensagens");
        System.out.println("-------------------");
    }
    
    public int qtdComunidadesMembro() {
        return this.comunidadesMembro.size();
    }

    public Solicitacao getSolicitacao(int i ) {
        return solicitacoes.get(i);
    }
    
    public Solicitacao getSolicitacao(String login) {
        for (Solicitacao sol: solicitacoes) {
            if (sol.getLogin().equals(login))
            return sol;
        }
        return null;
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

    public Amigo getAmigo(String login) {
        for (Amigo a: amigos) {
            if (a.getLogin().equals(login))
                return a;
        }
        return null;
    } 

    public Atributo getAtributo(int i) {
        return atributos.get(i);
    }
}
