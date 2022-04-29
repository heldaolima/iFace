package main;
import java.util.*;

abstract class Feed {
    ArrayList<Postagem> posts = new ArrayList<Postagem>();
    
    abstract void mostrarPosts();
    abstract boolean postar(Usuario user);
    abstract void apagarPost(Postagem post);

}
