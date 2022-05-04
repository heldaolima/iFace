package src.RedeSocial;

public interface Feed {
    abstract void mostrarPosts();
    abstract void publicar(Publicacao publicacao);
    abstract void apagarPost(Publicacao post);
}
