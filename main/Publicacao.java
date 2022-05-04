package main;

public class Publicacao {
    private PseudoUser usuario;
    private String conteudo;
    private boolean privado; 
    
    Publicacao(PseudoUser usuario, String conteudo, boolean privado) {
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.privado = privado;
    }

    public boolean getPrivado() {
        return this.privado;
    }

    public PseudoUser getAutor() {
        return this.usuario;
    }

    @Override
    public String toString() {
        return "@"+this.usuario.getLogin() + ": " + this.conteudo;
    }
}
