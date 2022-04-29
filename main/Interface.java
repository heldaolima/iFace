package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        IFace iFace = new IFace();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        while (escolha != -1) {
            titulo("iFace");
            if (iFace.logado == null) {
                System.out.println("[1] Criar conta\n[2] Fazer login\n[-1] Fechar");
                System.out.print("Escolha: ");
                escolha = sc.nextInt();
                sc.nextLine();

                switch (escolha) {
                    case 1:
                        titulo("Criação de conta");
                        if (iFace.novaConta())
                            System.out.println("Conta criada com sucesso\n");
                        else 
                            System.out.println("Criação de conta cancelada\n");
                        break;
                    case 2:
                        titulo("Entre na sua conta");
                        iFace.login();
                        if (iFace.logado == null)
                            System.out.println("Login ou senha inválidos\n");
                        else 
                            System.out.println("Logado com sucesso! Bem vind@, "+ iFace.logado.getNome());
                    default:
                        break;
                }
            }
            else {
                System.out.println("[1] Adicionar atributo\n[2] Editar atributo\n[3] Enviar solicitação de amizade\n[4] Responder solicitação de amizade\n[5] Enviar mensagem\n[6] Responder mensagem\n[7] Criar comunidade\n[8] Entrar em comunidade\n[9] Publicar no feed de notícias\n[10] Visualizar feed de notícias\n[11] Resumo da conta\n[12] Sair\n[13] Excluir conta");
                System.out.print("Escolha: ");
                escolha = sc.nextInt();
                sc.nextLine();
                if (escolha == 1) {
                    titulo("Novo atributo");
                    if (iFace.novoAtributo())
                        System.out.println("Atributo adicionado\n");
                    else
                        System.out.println("Criação de atributo cancelada");
                }

                else if (escolha == 2) {
                    titulo("Edição de atributo");
                    if (iFace.editarAtributo())
                        System.out.println("Edição concluída\n");
                    else 
                        System.out.println("Edição cancelada\n");
                }

                else if (escolha == 3) {
                    titulo("Enviar solicitacao");
                    if (iFace.enviarSolicitacao())
                        System.out.println("Solicitação enviada!\n");
                    else 
                        System.out.println("Envio de solicitação cancelado\n");
                }

                else if (escolha == 4) {
                    titulo("Responder solicitacao");
                    if (iFace.responderSolicitacao())
                        System.out.println("Solicitação respondida\n");
                    else 
                        System.out.println("Resposta cancelada\n");
                }
                else if (escolha == 5) {
                    titulo("Enviar mensagem");
                    if (iFace.enviarMensagem())
                        System.out.println("Mensagem enviada\n");
                    else
                        System.out.println("Envio de mensagem cancelado\n");
                }
                else if (escolha == 6) {
                    titulo("Responder mensagem");
                    if (iFace.enviarMensagem())
                        System.out.println("Mensagem respondida\n");
                    else
                        System.out.println("Resposta cancelada");
                }
                
            }
        
        }
    }

    public static void titulo(String nome) {
        System.out.println("-=-=- "+nome+" -=-=-");
    }

}
