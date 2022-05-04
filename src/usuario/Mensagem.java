package src.usuario;

public class Mensagem {
    private String sender, content;

    public boolean setSender(String sender) {
        if (sender == null || sender =="")
            return false;
        this.sender = sender;
        return true;
    }

    public boolean setContent(String content) {
        if (content == null || content == "")
            return false;
        this.content = content;
        return true;
    }

    public String getSender() {
        return this.sender;
    }

    public String getContent() {
        return this.content;
    }
    
    @Override
    public String toString() {
        return "@"+this.sender+": "+ this.content;
    }
}
