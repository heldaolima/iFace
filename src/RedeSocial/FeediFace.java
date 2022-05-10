package src.RedeSocial;
import java.util.ArrayList;

import src.RedeSocial.abstratas.Feed;
import src.usuario.PseudoUser;

public class FeediFace implements Feed{
    protected ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
    
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

    public ArrayList<Publicacao> getPublicacoes(PseudoUser user) {
        ArrayList<Publicacao> publi = new ArrayList<Publicacao>();
        for (Publicacao p: publicacoes) {
            if (p.getAutor().equals(user))
                publi.add(p);
        }
        return publi;
    }

    public void usuarioExcluido(PseudoUser excluido) {
        ArrayList<Publicacao> publiExcluido = getPublicacoes(excluido);
        // System.out.println("Excluindo as publicações");
        // for (Publicacao o: publiExcluido) {
        //     System.out.println(o.toString());
        // }
        for (Publicacao publi: publiExcluido) {
                publicacoes.remove(publi);
        }
    }
}
