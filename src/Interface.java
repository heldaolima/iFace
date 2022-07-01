package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.RedeSocial.IFace;
import src.RedeSocial.select.*;


public class Interface {
    public static void main(String[] args) {
        IFace iFace = new IFace();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        ArrayList<Select> unloggedIn = createUnloggedIn(), loggedIn = createLoggedIn();
        
        while (escolha != -1) {
            System.out.println("-=-=- iFace -=-=-");
            if (iFace.logado == null) {
                System.out.println("[1] Criar conta\n[2] Fazer login\n[-1] Fechar");
                System.out.print("Escolha: ");
                
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número\n");
                }
                if (escolha == -1)
                    break;
                
                escolha--;
                try {
                    if (unloggedIn.get(escolha).call(iFace))
                        System.out.print(unloggedIn.get(escolha).successMsg());
                    else
                        System.out.print(unloggedIn.get(escolha).failureMsg());
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("\nEscolha inválida. Insira um número válido\n");
                }
            }
            else {
                escolha = 0;
                System.out.println("[1] Adicionar atributo\n[2] Editar atributo\n[3] Enviar solicitação de amizade\n[4] Responder solicitação de amizade\n[5] Enviar mensagem\n[6] Criar comunidade\n[7] Entrar em comunidade\n[8] Visualizar feed de notícias\n[9] Publicar no feed de notícias\n[10] Resumo da conta\n[11] Sair\n[12] Excluir conta");
                System.out.print("Escolha: ");
                
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número\n");
                }
                escolha--;
                try {
                    if (loggedIn.get(escolha).call(iFace))
                        System.out.print(loggedIn.get(escolha).successMsg());
                    else
                        System.out.print(loggedIn.get(escolha).failureMsg());
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("\nEscolha inválida. Insira um número válido\n");
                }
            }
        }
        sc.close();
        System.out.println("\nEncerrando...\n");
    }
    
    public static ArrayList<Select> createUnloggedIn() {
        ArrayList<Select> unlogged = new ArrayList<>();
        unlogged.add(new CreateAccount());
        unlogged.add(new LoginAccount());
        return unlogged;
    }

    public static ArrayList<Select> createLoggedIn() {
        ArrayList<Select> logged = new ArrayList<>();
        
        logged.add(new CreateAtribute());
        logged.add(new EditAtribute());
        logged.add(new SendRequest());
        logged.add(new AnswerRequest());
        logged.add(new SendMessage());
        logged.add(new CreateComunity());
        logged.add(new BecomeMember());
        logged.add(new GetFeed());
        logged.add(new Publish());
        logged.add(new Summary());
        logged.add(new Logout());
        logged.add(new DestroyAccount());
        
        return logged;
    }

}
