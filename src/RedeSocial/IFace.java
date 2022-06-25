package src.RedeSocial;

import java.util.ArrayList;
import java.util.Scanner;

import src.RedeSocial.entrada.*;
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
    
    @Override
    public boolean novaConta(){
        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou no lugar de login");
        Entrada nome = new Nome(), login = new Login(), senha = new Senha();
        
        lerEntrada(nome, "Insira o seu nome e sobrenome: ");
        if (nome.getEntrada().equals("-1")) 
            return false;
        
        lerEntrada(login, "Crie um login: ");
        while(loginUsado(login.getEntrada())) {
            System.out.println("Este login já está em uso.");
            lerEntrada(login, "Crie um login: ");
        }
        
        if (login.getEntrada().equals("-1")) return false;

        lerEntrada(senha, "Crie uma senha: ");

        usuarios.add(new Usuario(nome.getEntrada(), login.getEntrada(), senha.getEntrada()));
        return true;
    }

    @Override
    public Logado login() throws WrongPasswordException, UserNotFoundException{
        System.out.print("Insira o seu login: ");        
        Usuario user = getUsuario(sc.nextLine());
        
        if (user == null) 
            throw new UserNotFoundException();
        
        System.out.print("Insira a sua senha: ");
        if (user.getSenha().equals(sc.nextLine())) {
            usuarios.remove(user); //temporariamente removido
            pseudoLogado = new PseudoUser(user.getNome(), user.getLogin());
            return (new Logado(user.getNome(), user.getLogin(), user.getSenha(), user.amigos, user.solicitacoes, user.comunidade, user.comunidadesMembro, user.atributos));
        }
        else
            throw new WrongPasswordException();
    }

    @Override
    public boolean novoAtributo(Logado logado) {
        Entrada nome = new Nome(), desc = new Texto();

        System.out.println("Caso queira cancelar, insira -1 no lugar do nome ou da descrição");

        lerEntrada(nome, "Nome do atributo: ");
        
        if (nome.getEntrada().equals("-1") ) 
            return false;
        
        
        lerEntrada(desc, "Descrição do atributo: ");

        if (desc.getEntrada().equals("-1"))
            return false;

        logado.novoAtributo(new Atributo(nome.getEntrada(), desc.getEntrada()));
        System.out.println("Atributo criado.\n"+nome.getEntrada()+" | "+desc.getEntrada());
        return true;
    }

    @Override
    public boolean editarAtributo(Logado logado) throws IndexOutOfBoundsException, NoAtributesException{
        if (logado.qtdAtributos() == 0) 
            throw new NoAtributesException();
        
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
            
            Entrada nome = new Nome(), desc = new Texto();
            if (esc == 1) {
                lerEntrada(nome, "Insira o novo nome: ");
                
                if (nome.getEntrada().equals("-1")) 
                    return false;

                logado.editarAtributoNome(i, nome.getEntrada());
                System.out.println("Nome editado.");
            }
            else if (esc == 2) {
                lerEntrada(desc, "Insira a nova descrição");
                
                if (desc.getEntrada().equals("-1")) 
                    return false;
                
                logado.editarAtributoDescricao(i, desc.getEntrada());
                System.out.println("Descrição editada.");
            }
        }
        return true;
    }

    @Override
    public boolean enviarSolicitacao(Logado logado) 
            throws IndexOutOfBoundsException, NoAvaliableUsersException{
        ArrayList<Integer> disponiveis = mostrarUsuariosSolicitacao(logado);
        
        if (disponiveis.size() == 0)
            throw new NoAvaliableUsersException();

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

        usuarios.get(i).recebeSolicitacao(new Solicitacao(logado.getNome(), logado.getLogin(), logado.qtdAmigos())); // IndexOutOfBouds aqui

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

        // IndexOutOfBoundsException
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

        //IndexOutOfBoundsException
       logado.getAmigo(i).mostrarMensagens();

        Mensagem msg = new Mensagem();
        msg.setSender(logado.getLogin());
        Entrada conteudo = new Texto();
        lerEntrada(conteudo, "Insira a nova mensagem: \n");
        
        msg.setContent(conteudo.getEntrada());
        logado.getAmigo(i).novaMensagem(msg); //o amigo tem a mensagem;

        return logado.enviarMensagem(logado.getAmigo(i), msg, usuarios); //para que o Usuario destinatário receba a mensagem
    }

    @Override
    public boolean novaComunidade(Logado logado) throws ComunityCreatedException{
        if (logado.temComunidade())
            throw new ComunityCreatedException();

        System.out.println("Insira -1 no lugar do nome ou da descrição para cancelar");
        Entrada nome = new Nome();

        lerEntrada(nome, "Insira o nome da comunidade: ");
        
        if (nome.getEntrada().equals("-1")) 
            return false;

        Entrada descricao = new Texto();
        lerEntrada(descricao, "Insira a descrição da comunidade");

        if (descricao.getEntrada().equals("-1")) 
            return false;

        Comunidade comunidade = new Comunidade(nome.getEntrada(), descricao.getEntrada(), pseudoLogado);
        
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
        
        if (!disponiveis.contains(esc))
            throw new IndexOutOfBoundsException();
        
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
        Entrada conteudo = new Texto();
        
        lerEntrada(conteudo, "No que você está pensando? (-1) cancela\n");
        
        if (conteudo.getEntrada().equals("-1")) 
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
            feed.publicar(new Publicacao(pseudoLogado, conteudo.getEntrada(), false));
        else
            feed.publicar(new Publicacao(pseudoLogado, conteudo.getEntrada(), true));

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

    public void lerEntrada(Entrada entrada, String comando) {
        while(true) {
            try {
                System.out.print(comando);
                entrada.setEntrada(sc.nextLine());
                break;
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}