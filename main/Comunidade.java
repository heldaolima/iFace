package main;

public class Comunidade {
    private String nome, descricao, dono;
    // private ArrayList<String> membros = new ArrayList<String>();

    Comunidade(String nome, String descricao, String dono) {
        this.nome = nome;
        this.descricao = dono;
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
        "\nDescrição: " + this.descricao +
        "\nFundador: " + this.dono;
    }

}
