package src.RedeSocial;
import java.util.ArrayList;

import src.usuario.PseudoUser;

public class Comunidade {
    private String nome, descricao; 
    private PseudoUser fundador;
    private ArrayList<PseudoUser> membros = new ArrayList<PseudoUser>();

    public Comunidade(String nome, String descricao, PseudoUser fundador) {
        this.nome = nome;
        this.descricao = descricao;
        this.fundador = fundador;
    }

    public void addMembro(PseudoUser membro) {
        membros.add(membro);
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
        "\nDescrição: " + this.descricao +
        "\nFundador: " + this.fundador.toString()+
        "\nQuantidade de membros: " + membros.size();
    }

}
