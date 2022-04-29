package main;

import java.util.ArrayList;
import java.util.Scanner;

import templates.RedeSocial;

public class IFace implements RedeSocial {
    public Logado logado = null;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public Scanner sc = new Scanner(System.in);

    @Override
    public boolean novaConta() {
        String nome, login, senha;
        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou no lugar de login");
        System.out.print("Insira o seu nome completo: ");
        nome = sc.nextLine();
        
        while (nome == "" || nome == null) {
            System.out.print("Nome inválido! Insira o seu nome completo:");
            nome = sc.nextLine();
        }
        if (nome.equals("-1")) return false;

        System.out.print("Crie um login: ");
        login = sc.nextLine();
        
        while (login == "" || login == null || loginUsado(login)) {
            System.out.print("Login inválido! Crie um login:");
            login = sc.nextLine();
        }

        if (login.equals("-1")) return false;

        System.out.print("Crie uma senha: ");
        senha = sc.nextLine();

        while (senha == "" || senha == null) {
            System.out.println("Senha inválida! Crie uma senha:");
            senha = sc.nextLine();
        }

        usuarios.add(new Usuario(nome, login, senha));
        System.out.println();
        return true;
    }

    @Override
    public boolean login() {
        System.out.print("Insira o seu login: ");        
        Logado fetched = (Logado) getUsuario(sc.nextLine());

        System.out.print("Insira a sua senha: ");
        if (fetched != null && fetched.getSenha().equals(sc.nextLine())) {
            logado = fetched;
            return true;
        }
        return false;
    }

    @Override
    public boolean novoAtributo() {
        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou da descrição");

        Atributo novo = new Atributo();

        System.out.print("Nome do atributo: ");
        while (!novo.setNome(sc.nextLine()))
            System.out.print("Nome do atributo: ");

        if (novo.getNome().equals("-1")) 
            return false;

        System.out.print("Descrição do atributo");
        while (!novo.setDescricao(sc.nextLine()))
            System.out.print("Descrição do atributo: ");
        
        if (novo.getDescricao().equals("-1")) 
            return false;

        System.out.println(novo.toString());

        logado.novoAtributo(novo);
        return true;

    }

    @Override
    public boolean editarAtributo() {
        if (logado.qtdAtributos() == 0) {
            System.out.println("Não há atributos!");
            return false;
        }
        
        logado.mostrarAtributos();
        int i;
        System.out.print("Insira o número do atributo que quer modificar (-1 cancela): ");
        i = sc.nextInt();
        sc.nextLine();

        i = i-1;

        if (i < 0 || i >= logado.qtdAtributos()) return false;
        
        int esc = 0;
        while (esc != -1) {
            System.out.println("[1] Editar nome\n[2] Editar descrição [-1] Encerrar");
            System.out.print("Escolha: ");
            esc = sc.nextInt();
            sc.nextLine();
            
            String novo;
            if (esc == 1) {
                System.out.print("Insira o novo nome ");
                novo = sc.nextLine();
                while (novo == null || novo == "") {
                    System.out.print("Entrada inválida! Insira o novo nome: ");
                    novo = sc.nextLine();
                }
                if (novo == "-1") return false;

                logado.editarAtributoNome(i, novo);
            }
            else if (esc == 2) {
                System.out.print("Insira a nova descrição: ");
                novo = sc.nextLine();
                while (novo == null || novo == "") {
                    System.out.print("Entrada inválida! Insira a nova descrição: ");
                    novo = sc.nextLine();
                }
                if (novo == "-1") return false;

                logado.editarAtributoDescricao(i, novo);
            }
        }
        return true;
    }

    @Override
    public boolean enviarSolicitacao() {
        if (usuarios.size() == 0) {
            System.out.println("Não há usuários disponíveis");
            return false;
        }

        ArrayList<Integer> disponiveis = mostrarUsuariosSolicitacao();
        System.out.print("Mandar solicitação para [índice]: ");
        int i = sc.nextInt();
        sc.nextLine();

        if (i < 0 || i >= usuarios.size() || !disponiveis.contains(i))
            return false;
        
        Solicitacao sol = new Solicitacao(logado.getNome(), logado.getLogin(), logado.qtdAmigos());
        usuarios.get(i).recebeSolicitacao(sol);

        return true;        
    }

    @Override
    public boolean responderSolicitacao() {
        if (logado.qtdSolicitacoes() == 0) {
            System.out.println("Não há solicitações");
            return false;
        }
        logado.mostrarSolicitacoes();
        System.out.println("Responder solicitção de [índice]: ");
        int i = sc.nextInt();
        sc.nextLine();
        i--;
        
        if (i < 0 || i >= logado.qtdSolicitacoes()) {
            System.out.println("Entrada inválida");
            return false;
        }

        System.out.println("[1] Aceitar\n[2] Recusar\n[-1] Cancelar");
        System.out.print("Escolha: ");
        int esc = sc.nextInt();
        sc.nextLine(); 
        
        while (esc < 0 || esc > 2) 
            return false;
        
        return logado.respoderSolicitacao(logado.getSolicitacao(i), esc, usuarios);   
        
    }

    @Override
    public boolean enviarMensagem() {
        if (logado.qtdAmigos() == 0) {
            System.out.println("Você tem 0 amigos");
            return false;
        }
        System.out.println("Você tem "+logado.qtdAmigos()+" amigos");
        logado.mostrarAmigos();
        System.out.println("Enviar mensagem para (índice): ");
        int i = sc.nextInt();
        sc.nextLine();
        i--;
        if (i < 0 || i >= logado.qtdAmigos()) {
            System.out.println("Entrada inválida");
            return false;
        }
        Amigo dest = logado.getAmigo(i);

        Mensagem nova = new Mensagem();
        nova.setSender(dest.login);
        System.out.println("Insira a mensgem: ");
        nova.setContent(sc.nextLine());
        
        return logado.enviarMensagem(dest, nova, usuarios);

    }

    @Override
    public boolean responderMensagem() {
        if (logado.qtdMensagens() == 0) {
            System.out.println("Não há mensagens disponíveis");
            return false;
        }
        

        return true;
    }

    @Override
    public boolean novaComunidade() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean virarMembroComunidade() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean publicarNoFeed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mostrarFeed() {
        // TODO Auto-generated method stub
    }

    
    @Override
    public Usuario logOut() {
        
        return null;
    }
    
    public Usuario getUsuario(String login) {
        for (Usuario user: usuarios) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public boolean loginUsado(String login) {
        for (Usuario user: usuarios) {
            if (user.getLogin().equals(login)) 
                return true;
        }
        return false;
    }

    public ArrayList<Integer> mostrarUsuariosSolicitacao() {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) != logado && logado.verificarAmizade(usuarios.get(i).getLogin()) == -1 && usuarios.get(i).verificarSolicitacao(logado.getLogin()) == -1) {
                System.out.println("["+i+"] " + usuarios.get(i).dadosBasicos());
                ans.add(i);
            } 
        }
        return ans;
    }
}
