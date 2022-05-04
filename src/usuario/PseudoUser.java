package src.usuario;

public class PseudoUser {
    private String nome, login;

    public PseudoUser(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLogin() {
        return this.login;
    }

    @Override
    public String toString() {
        return "Login: @" + this.login + 
        " | Nome: " + this.nome;
    }
}
