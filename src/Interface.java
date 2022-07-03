package src;

import java.util.Scanner;
import src.RedeSocial.IFace;
import src.RedeSocial.invoker.*;


public class Interface {
    public static void main(String[] args) {
        IFace iFace = new IFace();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        UnLoggedIn unloggedIn =  new UnLoggedIn();
        LoggedIn loggedIn = new LoggedIn();

        unloggedIn.setCommands();
        loggedIn.setCommands();

        while (escolha != -1) {
            System.out.println("-=-=- iFace -=-=-");
            if (iFace.logado == null) {
                System.out.println("[1] Criar conta\n[2] Fazer login\n[-1] Fechar");
                System.out.print("Escolha: ");
                
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                    if (escolha == -1)
                        break;
                    escolha--;
                    try {
                        unloggedIn.call(escolha, iFace);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nEscolha inválida. Insira um número válido\n");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número\n");
                }
            }
            else {
                escolha = 0;
                System.out.println("[1] Adicionar atributo\n[2] Editar atributo\n[3] Enviar solicitação de amizade\n[4] Responder solicitação de amizade\n[5] Enviar mensagem\n[6] Criar comunidade\n[7] Entrar em comunidade\n[8] Visualizar feed de notícias\n[9] Publicar no feed de notícias\n[10] Resumo da conta\n[11] Sair\n[12] Excluir conta");
                System.out.print("Escolha: ");
                
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                    escolha--;
                    try {
                        loggedIn.call(escolha, iFace);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("\nEscolha inválida. Insira um número válido\n");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número\n");
                }
            }
        }
        sc.close();
        System.out.println("\nEncerrando...\n");
    }
}
