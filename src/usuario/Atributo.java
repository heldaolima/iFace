package src.usuario;

public class Atributo {
    private String nome, descricao;

    public boolean setNome(String nome) {
        if (nome == null || nome =="" || nome.equals(" "))
            return false;
        this.nome = nome;
            return true;
    }

    public boolean setDescricao(String desc) {
        if (desc == null || desc == "" || desc.equals(" "))
            return false;
        this.descricao = desc;
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString(){
        return "Atributo: " + this.nome +
        "\nDescrição: " + this.descricao;
    }
}

//atributos ok