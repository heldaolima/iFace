package templates;

import main.Publicacao;

public interface Feed {
    abstract void mostrarPosts();
    abstract void publicar(Publicacao publicacao);
    abstract void apagarPost(Publicacao post);
}
