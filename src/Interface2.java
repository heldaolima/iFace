package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.RedeSocial.IFace;
import src.RedeSocial.Logado;
import src.RedeSocial.select.*;


public class Interface2 {
    public static void main(String[] args) {
        Logado logado = null;
        IFace iFace = new IFace();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        // Opções do usuáriu que não fez login
        ArrayList<Select> unloggedIn = createUnloggedIn(), loggedIn = createLoggedIn();
        
        while (true) {
            if (iFace.logado1 == null) {
                System.out.println("[1] Criar conta\n[2] Fazer login\n[-1] Fechar");
                System.out.print("Sua escolha: ");
                try {
                    escolha = Integer.parseInt(sc.nextLine());
                    if (escolha != 1 && escolha != 2 && escolha != -1) 
                        System.out.println("\nEntrada inválida! Por favor, insira um número válido!\n");
                    else {    
                        if (escolha == -1) break;
                        escolha--;
                        if (unloggedIn.get(escolha).call(iFace, logado)) 
                            System.out.print(unloggedIn.get(escolha).successMsg());
                        else
                            System.out.print(unloggedIn.get(escolha).failureMsg());
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
                    if (escolha < 1 || escolha > 12) 
                        System.out.println("\nEntrada inválida. Por favor, insira um número disponível no menu,\n");
                    else {
                        escolha--;
                        if (loggedIn.get(escolha).call(iFace, logado))
                            System.out.print(loggedIn.get(escolha).successMsg());
                        else
                            System.out.print(loggedIn.get(escolha).failureMsg());  
                    }
                } catch (NumberFormatException e) {
                    System.err.println("\nEntrada inválida. Por favor, insira um número.\n");
                }

                
            }
        }
        System.out.println("\nEncerrando...\n");
        sc.close();
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
