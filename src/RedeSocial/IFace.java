package src.RedeSocial;

import java.util.ArrayList;
import java.util.Scanner;

import src.RedeSocial.abstratas.RedeSocial;
import src.RedeSocial.customExceptions.*;
import src.usuario.Amigo;
import src.usuario.Atributo;
import src.usuario.Mensagem;
import src.usuario.PseudoUser;
import src.usuario.Solicitacao;

public class IFace implements RedeSocial {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    protected FeediFace feed = new FeediFace();
    protected ArrayList<Comunidade> comunidades = new ArrayList<Comunidade>();
    protected PseudoUser pseudoLogado = null;
    public Scanner sc = new Scanner(System.in);

    public String lerSenha() throws InvalidPasswordException, EmptyInputException {
        String senha = sc.nextLine();
        if (!entradaValida(senha))
            throw new EmptyInputException();
        else if (allSpaces(senha))
            throw new InvalidPasswordException("A sua senha não pode ser só de espaços.");
        else if (senha.length() < 6)
            throw new InvalidPasswordException("A sua senha deve ter pelo menos 6 caracteres.");
        return senha;
    }

    public String lerLogin() throws InvalidLoginException, EmptyInputException {
        String login = sc.nextLine();
        if (!entradaValida(login)) 
            throw new EmptyInputException();
        else if (loginUsado(login))
            throw new InvalidLoginException("Este login já está em uso.");    
        else if (!loginValido(login))
            throw new InvalidLoginException("Seu login não pode conter espaços nem '@'.");       
        else if (allNumbers(login))
            throw new InvalidLoginException("Seu login não pode ser composto apenas de números");
        return login;
    }

    public String lerTexto() throws InvalidInputException, EmptyInputException {
        String texto = sc.nextLine();
        if (!entradaValida(texto))
            throw new EmptyInputException();
        else if (allSpaces(texto))
            throw new InvalidInputException("A entrada não pode ser só de espaços.");
        return texto;
    }

    public String lerNome() throws InvalidInputException, EmptyInputException {
        String nome = sc.nextLine();
        if (!entradaValida(nome)) 
            throw new EmptyInputException();
        else if (!nomeValido(nome))
            throw new InvalidInputException("A entrada não pode conter números.");
        else if (allSpaces(nome))
            throw new InvalidInputException("A entrada pode ser só de espaços.");
        return nome;
    }

    @Override
    public boolean novaConta(){
        String nome, login, senha;
        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou no lugar de login");
        
        while (true) {
            try {
                System.out.print("Insira o seu nome e sobrenome: ");
                nome = lerNome();
                break;
            } catch (InvalidInputException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }

        if (nome.equals("-1")) return false;

        while (true) {
            try {
                System.out.print("Crie um login: ");
                login = lerLogin();
                break;
            } catch (InvalidLoginException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }
        
        
        if (login.equals("-1")) return false;


        while (true) {
            try {
                System.out.print("Crie uma senha: ");
                senha = lerSenha();
                break;
            } catch (InvalidPasswordException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }

        usuarios.add(new Usuario(nome, login, senha));
        return true;
    }

    @Override
    public Logado login() {
        System.out.print("Insira o seu login: ");        
        Usuario user = getUsuario(sc.nextLine());
        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return null;
        }
        System.out.print("Insira a sua senha: ");
        if (user != null && user.getSenha().equals(sc.nextLine())) {
            usuarios.remove(user); //temporariamente removido
            pseudoLogado = new PseudoUser(user.getNome(), user.getLogin());
            return (new Logado(user.getNome(), user.getLogin(), user.getSenha(), user.amigos, user.solicitacoes, user.comunidade, user.comunidadesMembro, user.atributos));
        }
        return null;
    }

    @Override
    public boolean novoAtributo(Logado logado) {
        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou da descrição");

        Atributo novo = new Atributo();

        String nome, desc;
        while (true) {
            try {
                System.out.print("Nome do atributo: ");
                nome = lerTexto();
                break;
            } catch (InvalidInputException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }

        if (nome.equals("-1") ) 
            return false;
        
        novo.setNome(nome);
        
        while (true) {
            try {
                System.out.print("Descrição do atributo: ");
                desc = lerTexto();
                break;
            } catch (InvalidInputException | EmptyInputException e) {
                
            }
        }

        if (desc.equals("-1"))
            return false;

            novo.setDescricao(desc);
        
        System.out.println("Seu atributo: ");
        System.out.println(novo.toString());

        logado.novoAtributo(novo);
        return true;

    }

    @Override
    public boolean editarAtributo(Logado logado) throws IndexOutOfBoundsException{
        if (logado.qtdAtributos() == 0) {
            System.out.println("Não há atributos!");
            return false;
        }
        
        logado.mostrarAtributos();
        int i;
        System.out.print("Insira o número do atributo que quer modificar (-1 cancela): ");
        
        while (true) {
            try {
                i = Integer.parseInt(sc.nextLine());
                i = i-1;
                break;
            } catch(NumberFormatException e) {
                System.err.println("Entrada inválida! Por favor, insira um número");
            }

        }
        
        System.out.println("\nEditando: \n"+logado.getAtributo(i).toString()+"\n");
        int esc = 0;
        while (esc != -1) {
            System.out.println("[1] Editar nome\n[2] Editar descrição\n[-1] Encerrar");
            System.out.print("Escolha: ");
            while (true) {
                try {
                    esc = Integer.parseInt(sc.nextLine());
                    if (esc != -1 && (esc < 0 || esc > 2)) {
                        System.out.println("Entrada inválida. Insira um número disponível no menu");
                        esc = Integer.parseInt(sc.nextLine());
                    }
                    break;
                } catch(NumberFormatException e) {
                    System.out.println("Entrada inválida! Por favor, insira um número");
                }

            }
            
            String novo;
            if (esc == 1) {
                while (true) {
                    try {
                        System.out.print("\nInsira o novo nome: ");
                        novo = lerNome();
                        break;
                    } catch (InvalidInputException | EmptyInputException e) {
                        System.err.println(e.getMessage());
                    }
                }
                if (novo == "-1") return false;

                logado.editarAtributoNome(i, novo);
            }
            else if (esc == 2) {
                System.out.print("\nInsira a nova descrição: ");
                while (true) {
                    try {
                        novo = lerTexto();
                        break;
                    } catch (InvalidInputException | EmptyInputException e) {
                        System.err.println(e.getMessage());
                    }
                }
                if (novo.equals("-1")) return false;
                logado.editarAtributoDescricao(i, novo);
            }
        }
        return true;
    }

    @Override
    public boolean enviarSolicitacao(Logado logado) throws IndexOutOfBoundsException{
        ArrayList<Integer> disponiveis = mostrarUsuariosSolicitacao(logado);
        
        if (disponiveis.size() == 0) {
            System.out.println("Não há usuários disponíveis");
            return false;
        }

        System.out.print("Mandar solicitação para [índice]: ");
        int i;

        while (true) {
            try {
                i = Integer.parseInt(sc.nextLine());
                break;
            } catch(NumberFormatException e) {
                System.err.println("Entrada inválida! Por favor, insira um número");
            }

        }
        
        Solicitacao sol = new Solicitacao(logado.getNome(), logado.getLogin(), logado.qtdAmigos());
        
        usuarios.get(i).recebeSolicitacao(sol);

        return true;        
    }

    @Override
    public boolean responderSolicitacao(Logado logado) 
            throws IndexOutOfBoundsException, NoRequestsException {
        
        if (logado.qtdSolicitacoes() == 0)
            throw new NoRequestsException();

        logado.mostrarSolicitacoes();
        System.out.print("Responder solicitção de [índice]: ");
        
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.nextLine());
                i--;
                break;
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida! Por favor, insira um número");
            }

        }

        // Pode lançar o indexOutOfBounds
        System.out.println("Usuário "+logado.getSolicitacao(i));
        
        System.out.println("[1] Aceitar\n[2] Recusar\n[-1] Cancelar");
        System.out.print("Escolha: ");
        int esc;
        while (true) {
            try {
                esc = Integer.parseInt(sc.nextLine());
                while ((esc < 1 || esc > 2) && esc != -1) {
                    System.out.println("Entrada inválida! Por favor, insira um número disponível no menu!");
                    esc = Integer.parseInt(sc.nextLine());
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número!");
            }
        }
        
        if (esc == -1) return false;

        else {
            logado.solicitacoes.remove(logado.getSolicitacao(i));
            if (esc == 2)
                System.out.println("Solicitação recusada");
            else 
                logado.respoderSolicitacao(logado.getSolicitacao(i), usuarios);   
        }
        return true;
    }

    @Override
    public boolean enviarMensagem(Logado logado) 
            throws IndexOutOfBoundsException, NoFriendsException{
        
        if (logado.qtdAmigos() == 0) 
            throw new NoFriendsException();

        System.out.println("Você tem "+logado.qtdAmigos()+" amigos");
        logado.mostrarAmigos();
        System.out.print("Enviar mensagem para (índice): ");
        
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.nextLine());
                i--;
                break;
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida! Por favor, insira um número");
            }

        }
       
       logado.getAmigo(i).mostrarMensagens(); //pode lançar o indexOutOfBounds

        Mensagem msg = new Mensagem();
        msg.setSender(logado.getLogin());
        String conteudo;
        
        while (true) {
            try {
                System.out.println("Insira a nova mensgem: ");
                conteudo = lerNome();  
                break;             
            } catch(InvalidInputException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }

        msg.setContent(conteudo);
        logado.getAmigo(i).novaMensagem(msg); //o amigo tem a mensagem;

        return logado.enviarMensagem(logado.getAmigo(i), msg, usuarios); //para que o Usuario destinatário receba a mensagem
    }

    @Override
    public boolean novaComunidade(Logado logado) throws ComunityCreatedException{
        if (logado.temComunidade())
            throw new ComunityCreatedException();

        System.out.println("Insira -1 no lugar do nome ou da descrição para cancelar");
        String nome;
        while (true) {
            try {
                System.out.print("Insira o nome da comunidade: ");
                nome = lerNome();
                break;
            } catch (InvalidInputException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }

        }
        
        if (nome.equals("-1")) 
            return false;

        String descricao;
        while (true) {
            try {
                System.out.print("Insira a descrição da comunidade: ");
                descricao = lerTexto();
                break;
                
            } catch (InvalidInputException | EmptyInputException e) {
                System.err.println(e.getMessage());
            }
        }

        if (descricao.equals("-1")) return false;

        Comunidade comunidade = new Comunidade(nome, descricao, pseudoLogado);
        comunidades.add(comunidade);

        return logado.criarComunidade(comunidade);
    }

    @Override
    public boolean virarMembroComunidade(Logado logado) 
                throws NoComunitiesException, IndexOutOfBoundsException{
        
        ArrayList<Integer> disponiveis = mostrarComunidades(logado);
        if (disponiveis.size() == 0) 
            throw new NoComunitiesException();

        System.out.println("Entrar na comunidade (indice): ");
        int esc;
        while (true) {
            try {
                esc = Integer.parseInt(sc.nextLine()); 
                break;
            } catch(NumberFormatException e) {
                System.err.print("Entrada inválida. Insira um número: ");
            }
        }
        
        System.out.println("Comunidade escolhida: "+comunidades.get(esc).getNome());
        comunidades.get(esc).addMembro(pseudoLogado);
        
        logado.virarMembro(comunidades.get(esc));

        return true;
    }

    @Override
    public void mostrarFeed(Logado logado) {
        logado.verFeed(feed.publicacoes);
    }

    @Override
    public boolean publicarNoFeed(Logado logado) {
        String conteudo;
        System.out.println("No que você está pensando? (-1) cancela");
        
        while(true) {
            try {
                conteudo = lerTexto();
                break;
            } catch (EmptyInputException | InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        }
        
        if (conteudo.equals("-1")) 
            return false;
        

        System.out.println("Defina a privacidade da publicação:\n[1] Pública\n[2] Privada\n[-1] Cancelar publicação");
        System.out.print("Sua escolha: ");
        
        int esc;
        while (true) {
            try {
                esc = Integer.parseInt(sc.nextLine());
                while (esc != 1 && esc != 2 && esc != -1) {
                    System.out.print("Insira uma opção disponível. Sua escolha: ");
                    esc = Integer.parseInt(sc.nextLine());
                }
                break;
            } catch (NumberFormatException e) {
                System.err.print("Entrada inválida. Insira um número disponível: ");
            }
        }

        if (esc == -1) 
            return false;
        else if (esc == 1) 
            feed.publicar(new Publicacao(pseudoLogado, conteudo, false));
        else
            feed.publicar(new Publicacao(pseudoLogado, conteudo, true));

        return true;
    }

    @Override
    public void resumoDaConta(Logado logado) {
        logado.resumoDaConta();
    }

    @Override
    public Logado logOut(Logado logado) {
        usuarios.add((Usuario) logado); 
        pseudoLogado = null;
        return null;
    }

    @Override
    public boolean excluirConta(Logado logado) throws WrongPasswordException{
        System.out.println("Para confirmar a operação, insira a sua senha novamente: ");
        if (!logado.getSenha().equals(sc.nextLine())) 
            throw new WrongPasswordException();
        System.out.println("Excluindo sua conta...");

        if (logado.temComunidade())
            comunidades.remove(logado.comunidade);

        for (Usuario user: usuarios) {
            Amigo Amigologado = user.getAmigo(logado.getLogin());
            Solicitacao solicitacaoLogado = user.getSolicitacao(logado.getLogin());
            
            user.removerAmigo(Amigologado);
            user.removeSolicitacao(solicitacaoLogado);
            if (logado.temComunidade())
                user.removerComunidadeMembro(logado.comunidade.getNome());
        }

        feed.usuarioExcluido(pseudoLogado);
        pseudoLogado = null;

        return true;
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

    public boolean loginValido(String login) {
        if (login.contains(" ") || login.contains("@") || login.contains("#"))
            return false;
        return true;
    }

    public ArrayList<Integer> mostrarUsuariosSolicitacao(Logado logado) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        for (Usuario user: usuarios) {
            if (logado.verificarAmizade(user.getLogin()) == -1 && user.verificarSolicitacao(logado.getLogin()) == -1 && logado.verificarSolicitacao(user.getLogin()) == -1) {
                System.out.println("["+i+"] " + user.dadosBasicos());
                ans.add(i);
            }
            i++;
        }
        return ans;
    }

    public boolean nomeComunidadeUsado(String nome) {
        for (Comunidade com: comunidades) {
            if (com.getNome().equals(nome)) 
                return true;
        }
        return false;
    }

    public int qtdComunidades() {
        return comunidades.size();
    }

    public ArrayList<Integer> mostrarComunidades(Logado logado) {
        ArrayList<Integer> disponiveis = new ArrayList<Integer>();
        int i = 0;
        for (Comunidade com: comunidades) {
            if (!logado.eDono(com) && !logado.eMembro(com)) {
                System.out.println("["+i+"] "+com.toString());
                disponiveis.add(i);
            }
        }
        return disponiveis;
    }

    public void mostrarUsuarios() {
        for (Usuario u: usuarios) {
            System.out.println(u.dadosBasicos());
        }
    }

    // não pode ser tudo espaço nem ter números
    public boolean nomeValido(String entrada) {
        if (!entrada.equals("-1")) { //-1 é a etnrada geral de cancelamento de operação
            char[] chars = entrada.toCharArray();
            for (char c: chars) {
                if (Character.isDigit(c))
                    return false;
            }
        }
        return true;
    }

    public boolean entradaValida(String entrada) {
        if (entrada.equals("") || entrada == null)
            return false;
        return true;
    }

    public boolean allSpaces(String entrada) {
        char[] chars = entrada.toCharArray();
        int contSpaces = 0;
        for (char c: chars) {
            if (Character.isSpaceChar(c)) 
                contSpaces++;
        }
        return contSpaces == entrada.length();
    }

    public boolean allNumbers(String entrada) {
        char[] chars = entrada.toCharArray();
        int contDigits = 0;
        for (char c: chars) {
            if (Character.isDigit(c)) 
                contDigits++;
        }
        return contDigits == entrada.length();
    }

}

// Custom exceptions here

