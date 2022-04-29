package main; //ele deve ter acesso ao package da rede E o do usuário, mas só ele
import java.util.ArrayList;

public class Amigo extends PseudoUser {
    
    protected String nome, login;
    Amigo(String nome, String login){
        super(nome, login);
        // this.amizade = amizade;
    }

    public void SolicitacaoAceita(ArrayList<Usuario> usuarios, Usuario aceitou) {
        for (Usuario user: usuarios) {
            if (user.getLogin().equals(this.login)) {
                user.adicionarAmigo(new Amigo(aceitou.getNome(), aceitou.getLogin()));
            }
        }
    }

    public void trocaDeMensagens(Usuario logado, Mensagem msg,ArrayList<Usuario> usuarios) {
        for (Usuario amigo: usuarios) {
            if (amigo.getLogin().equals(this.login)) {
                amigo.novaMensagem(msg);
            }
        }
    }
    
}
