package main;

public class Solicitacao extends PseudoUser{
    private int qtdAmigos;

    Solicitacao(String nome, String login, int qtdAmigos) {
        super(nome, login);
        this.qtdAmigos = qtdAmigos;
    }

    @Override
    public String toString() {
        return super.toString() + "| " + this.qtdAmigos + " amigos"; 
    }
}
