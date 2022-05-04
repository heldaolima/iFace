package src.usuario; //ele deve ter acesso ao package da rede E o do usuário, mas só ele
import java.util.ArrayList;

import src.RedeSocial.Usuario;

public class Amigo extends PseudoUser {
    protected ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

    public Amigo(String nome, String login){
        super(nome, login);
    }

    public void SolicitacaoAceita(ArrayList<Usuario> usuarios, Usuario aceitou) {
        for (Usuario user: usuarios) {
            if (user.getLogin().equals(this.getLogin())) {
                user.adicionarAmigo(new Amigo(aceitou.getNome(), aceitou.getLogin()));
            }
        }
    }
    
    public void novaMensagem(Mensagem msg) {
        mensagens.add(msg);
    }

    public int qtdMensagens() {
        return mensagens.size();
    }

    public void mostrarMensagens() {
        int i = 1;
        for(Mensagem msg: mensagens) { 
            System.out.println("    ["+i+"] "+msg.toString());
        }
    }
    
}
