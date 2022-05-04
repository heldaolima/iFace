package main;

import java.util.Scanner;

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
                escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 1) {
                        titulo("Criação de conta");
                        if (iFace.novaConta())
                            System.out.println("Conta criada com sucesso\n");
                        else 
                            System.out.println("Criação de conta cancelada\n");
                }
                else if (escolha == 2) {
                    titulo("Entre na sua conta");
                    logado = iFace.login();
                    if (logado == null)
                        System.out.println("Login ou senha inválidos\n");
                    else 
                        System.out.println("Logado com sucesso! Bem vind@, "+ logado.getNome());
                }
                else 
                    System.out.println("\nEntrada inválida! \n");
            }
            else {
                System.out.println("[1] Adicionar atributo\n[2] Editar atributo\n[3] Enviar solicitação de amizade\n[4] Responder solicitação de amizade\n[5] Enviar mensagem\n[6] Criar comunidade\n[7] Entrar em comunidade\n[8] Visualizar feed de notícias\n[9] Publicar no feed de notícias\n[10] Resumo da conta\n[11] Sair\n[12] Excluir conta");
                System.out.print("Escolha: ");
                escolha = sc.nextInt();
                sc.nextLine();
                if (escolha == 1) {
                    titulo("Novo atributo");
                    if (iFace.novoAtributo(logado))
                        System.out.println("Atributo adicionado\n");
                    else
                        System.out.println("Criação de atributo cancelada");
                }

                else if (escolha == 2) {
                    titulo("Edição de atributo");
                    if (iFace.editarAtributo(logado))
                        System.out.println("Edição concluída\n");
                    else 
                        System.out.println("Edição cancelada\n");
                }

                else if (escolha == 3) {
                    titulo("Enviar solicitacao");
                    if (iFace.enviarSolicitacao(logado))
                        System.out.println("Solicitação enviada!\n");
                    else 
                        System.out.println("Envio de solicitação cancelado\n");
                }

                else if (escolha == 4) {
                    titulo("Responder solicitacao");
                    if (iFace.responderSolicitacao(logado))
                        System.out.println("Solicitação respondida\n");
                    else 
                        System.out.println("Resposta cancelada\n");
                }
                else if (escolha == 5) {
                    titulo("Enviar mensagem");
                    if (iFace.enviarMensagem(logado))
                        System.out.println("Mensagem enviada\n");
                    else
                        System.out.println("Envio de mensagem cancelado\n");
                }
                else if (escolha == 6) {
                    titulo("Criar comunidade");
                    if (iFace.novaComunidade(logado))
                        System.out.println("Comunidade criada\n");
                    else 
                        System.out.println("Criação de comunidade cancelada\n");
                }
                else if (escolha == 7){
                    titulo("Entrar em uma comunidade");
                    if (iFace.virarMembroComunidade(logado)) 
                        System.out.println("Você virou membro da comunidade!\n");
                    else 
                        System.out.println("Operação cancelada\n");
                }
                else if (escolha == 8) {
                    titulo("Feed de notícias");
                    iFace.mostrarFeed(logado);
                    System.out.println();
                }
                else if (escolha == 9) {
                    titulo("Publicar no feed");
                    if (iFace.publicarNoFeed(logado)) 
                        System.out.println("Publicação disponível no feed\n");
                    else 
                        System.out.println("Publicação cancelada\n");
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
                    if (iFace.excluirConta(logado)) {
                        System.out.println("Conta excluída");
                        logado = null;
                    }
                    else
                        System.out.println("Exclusão de conta cancelada");
                }
            }
        }
        sc.close();
    }

    public static void titulo(String nome) {
        System.out.println("-=-=- "+nome+" -=-=-");
    }
}
