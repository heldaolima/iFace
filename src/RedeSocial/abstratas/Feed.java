package src.RedeSocial.abstratas;

import src.RedeSocial.Publicacao;

public interface Feed {
    abstract void mostrarPosts();
    abstract void publicar(Publicacao publicacao);
    abstract void apagarPost(Publicacao post);
}
