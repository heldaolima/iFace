package src;
import java.util.Scanner;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.customExceptions.ComunityCreatedException;
import src.RedeSocial.customExceptions.NoAtributesException;
import src.RedeSocial.customExceptions.NoAvaliableUsersException;
import src.RedeSocial.customExceptions.NoFriendsException;
import src.RedeSocial.customExceptions.NoRequestsException;
import src.RedeSocial.customExceptions.UserNotFoundException;
import src.RedeSocial.customExceptions.WrongPasswordException;
import src.RedeSocial.customExceptions.NoComunitiesException;

public class Interface {
    public static void main(String[] args) {
        Logado logado = null;
        IFace iFace = new IFace();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        
        while (escolha != -1) {
            titulo("iFace");
            if (logado == null) {
                System.out.println("[1] Criar conta\n[2] Fazer login\n[-1] Fechar");
                System.out.print("Escolha: ");

                try {
                    escolha = Integer.parseInt(sc.nextLine());
                    if (escolha != 1 && escolha != 2 && escolha != -1) 
                        System.out.println("\nEntrada inválida! Por favor, insira um número válido!\n");
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número\n");
                }

                if (escolha == 1) {
                        titulo("Criação de conta");
                        if (iFace.novaConta())
                            System.out.println("\nConta criada com sucesso\n");
                        else 
                            System.out.println("\n\nCriação de conta cancelada\n");
                }
                else if (escolha == 2) {
                    titulo("Entre na sua conta");
                    try {
                        logado = iFace.login();
                        if (logado == null)
                            System.out.println("\nLogin ou senha inválidos\n");
                        else
                            System.out.println("\nLogado com sucesso! Bem vind@, "+ logado.getNome());
                    } catch (WrongPasswordException | UserNotFoundException e) {
                        System.out.println("\n"+e.getMessage()+"\n");
                    }
                }
            }
            else {
                escolha = 0;
                System.out.println("[1] Adicionar atributo\n[2] Editar atributo\n[3] Enviar solicitação de amizade\n[4] Responder solicitação de amizade\n[5] Enviar mensagem\n[6] Criar comunidade\n[7] Entrar em comunidade\n[8] Visualizar feed de notícias\n[9] Publicar no feed de notícias\n[10] Resumo da conta\n[11] Sair\n[12] Excluir conta");
                System.out.print("Escolha: ");
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                    if (escolha < 1 || escolha > 12) 
                        System.out.println("\nEntrada inválida. Por favor, insira um número disponível no menu,\n");
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número.\n");
                } 


                if (escolha == 1) {
                    titulo("Novo atributo");
                    if (iFace.novoAtributo(logado))
                        System.out.println("\nAtributo adicionado\n");
                    else
                        System.out.println("\nCriação de atributo cancelada");
                }

                else if (escolha == 2) {
                    titulo("Edição de atributo");
                    try {
                        if (iFace.editarAtributo(logado)) {
                            System.out.println("\nEdição concluída\n");
                        }
                        else {
                            System.out.println("\nEdição cancelada\n");
                        }
                    } catch(IndexOutOfBoundsException e) {
                        System.err.println("\nErro! Atributo não encontrado\n");
                    } catch(NoAtributesException e) {
                        System.err.println(e.getMessage());
                    }
                }
                else if (escolha == 3) {
                    titulo("Enviar solicitacao");
                    try {
                        if (iFace.enviarSolicitacao(logado))
                            System.out.println("\nSolicitação enviada!\n");
                        else 
                            System.out.println("\nEnvio de solicitação cancelado\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nErro! Usuário não encontrado!");
                    } catch (NoAvaliableUsersException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    }
                }

                else if (escolha == 4) {
                    titulo("Responder solicitacao");
                    try {
                        if (iFace.responderSolicitacao(logado))
                            System.out.println("\nSolicitação respondida\n");
                        else 
                            System.out.println("\nResposta cancelada\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nErro! Usuário não encontrado!\n");
                    } catch (NoRequestsException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    }
                }
                else if (escolha == 5) {
                    titulo("Enviar mensagem");
                    try {
                        if (iFace.enviarMensagem(logado))
                            System.out.println("\nMensagem enviada\n");
                        else
                            System.out.println("\nEnvio de mensagem cancelado\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nErro! Amigo não encontrado!\n");
                    } catch (NoFriendsException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    }
                }
                else if (escolha == 6) {
                    titulo("Criar comunidade");
                    try {
                        if (iFace.novaComunidade(logado))
                            System.out.println("\nComunidade criada\n");
                        else 
                            System.out.println("\nCriação de comunidade cancelada\n");
                    } catch(ComunityCreatedException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    }
                }
                else if (escolha == 7){
                    titulo("Entrar em uma comunidade");
                    try {
                        if (iFace.virarMembroComunidade(logado)) 
                            System.out.println("\nVocê virou membro da comunidade!\n");
                        else 
                            System.out.println("\nOperação cancelada\n");                        
                    } catch (NoComunitiesException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nComunidade não encontrada\n");
                    }
                }
                else if (escolha == 8) {
                    titulo("Feed de notícias");
                    iFace.mostrarFeed(logado);
                    System.out.println();
                }
                else if (escolha == 9) {
                    titulo("Publicar no feed");
                    if (iFace.publicarNoFeed(logado)) 
                        System.out.println("\nPublicação disponível no feed\n");
                    else 
                        System.out.println("\nPublicação cancelada\n");
                }
                else if (escolha == 10) {
                    titulo("Resumo da conta");
                    iFace.resumoDaConta(logado);
                }
                else if (escolha == 11) {
                    System.out.println("\nSaindo...\n");
                    logado = iFace.logOut(logado);
                    iFace.mostrarUsuarios();
                }
                else if (escolha == 12) {
                    titulo("Exclusão da conta");
                    try {
                        if (iFace.excluirConta(logado)) {
                            System.out.println("\nConta excluída\n");
                            logado = null;
                        }
                        else
                            System.out.println("\nExclusão de conta cancelada\n");
                    } catch (WrongPasswordException e) {
                        System.err.println("\n"+e.getMessage()+"\n");
                    }
                }
            }
        }
        System.out.println("\nEncerrando...\n");
        sc.close();
    }

    public static void titulo(String nome) {
        System.out.println("-=-=- "+nome+" -=-=-");
    }
}
