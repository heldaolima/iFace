package main;
import templates.Feed;
import java.util.ArrayList;

public class FeediFace implements Feed{
    ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
    
    @Override
    public void mostrarPosts() {
        for (Publicacao p: publicacoes) {
            System.out.println(p.toString());
        }
    }

    @Override
    public void publicar(Publicacao publicacao) {
        this.publicacoes.add(publicacao);
    }

    @Override
    public void apagarPost(Publicacao post) {
        this.publicacoes.remove(post);        
    }

    public void usuarioExcluido(PseudoUser excluido) {
        for (Publicacao publi: publicacoes) {
            if (publi.getAutor().equals(excluido)) 
                publicacoes.remove(publi);
        }
    }
}
