package main;
import java.util.ArrayList;

public class Logado extends Usuario {
    public Logado(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public void editarAtributoNome(int i, String nome) {
        atributos.get(i).setNome(nome);
    }

    public void editarAtributoDescricao(int i, String descricao) {
        atributos.get(i).setDescricao(descricao);
    }
    
    public boolean respoderSolicitacao(Solicitacao sol, int acao, ArrayList<Usuario> usuarios) {
        solicitacoes.remove(sol);

        if (acao == 1) { //aceitar
            Amigo amigo = new Amigo(sol.getNome(), sol.getLogin());
            amigo.SolicitacaoAceita(usuarios, this);
            this.adicionarAmigo(amigo);
        
            return true;
        }
        System.out.println("Solicitação recusada");
        return false;
    }

    public boolean enviarMensagem(Amigo dest, Mensagem msg, ArrayList<Usuario> usuarios) {
        for (Amigo a: amigos) {
            if (a == dest) {
                a.trocaDeMensagens(this, msg, usuarios);
                return true;
            }
        }
        return false;
    }

}
