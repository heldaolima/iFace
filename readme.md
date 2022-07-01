# Projeto P2 - Rede de relacionamentos
Trata-se da implementação de um sistema que mantém uma rede de relacionamentos, semelhante a uma rede social.

## Instruções de execução
É no arquivo `src/Interface.java` que a rede funciona. É preciso que ele seja executado a partir da pasta do projeto, e não de dentro de `src`, por conta dos pacotes.

Lá estão os menus, e cada opção chama uma função da rede social, chamada *iFace*.

O primeiro menu tem as opções:
- [1] Criar conta
- [2] Fazer login

Caso faça login, o usuário tem as seguintes opções:
- [1] Adicionar atributo 
- [2] Editar atributo
- [3] Enviar solicitação de amizade
- [4] Responder solicitação de amizade
- [5] Enviar mensagem
- [6] Criar comunidade
- [7] Entrar em comunidade
- [8] Publicar no feed de notícias
- [9] Visualizar feed de notícias
- [10] Resumo da conta
- [11] Sair
- [12] Excluir conta

Conforme as funcionalidades demandadas para o projeto.

# Notas sobre a implementação
## Atributos
Interpretei que Atributo na rede social é uma característica que o usuário escolhe mostrar a seu respeito. Por exemplo, o atributo "Trabalho" com a descrição "Sou engenheiro de Software na empresa X".

## Comunidades
No momento, cada usuário é capaz de criar apenas uma comunidade. 

## Conceitos de Programação Orientada a Objetos
Dentro da pasta `src` há, além da Interface, dois pacotes. O pacote `usuario` guarda classes de atributos de um usuário nessa rede. Em `RedeSocial` ficam os componentes da rede social, que inclui o usuário.

- `RedeSocial/abstratas` Guarda as classes abstratas utilizadas. No caso:
	- `RedeSocial.java` Template conforme a rede social pedida
	- `Perfil.java` Template para a implementação de um perfil de rede social
	- `Feed.java` Template para uma implementação de feed de rede social
- `RedeSocial/IFace.java` O iFace em si, implementando as funções definidas no template, executa todas as funções chamadas a partir de `src/Interface.java`
- `RedeSocial/Usuario.java` O usuário do iFace.
- `RedeSocial/Logado.java` Subclasse de Usuario, representa um usuário logado na rede. Além de todas as funções de Usuario, de cunho mais simples, apenas um usuário Logado é capaz de fazer certas edições e de responder mensagens. Além disso, é para um usuário logado que o Feed de Notícias aparece, o que deve ser levado em conta devido à natureza privada de algumas postagens.
- `RedeSocial/FeediFace.java` Feed do iFace: coleção de publicações e suas funções.
- `RedeSocial/Publicacao.java` Publicação que será incluída dentro do Feed, com autor, conteúdo e configuração de privacidade.
- `RedeSocial/Comunidade.java` Comunidade do iFace, com nome, descrição, fundador e membros.

É importante que essas classes estejam todas no mesmo pacote, pois certos atributos são `protected`, isto é, acessíveis apenas às subclasses e às classes do mesmo pacote. Por exemplo, o usuário Logado deve ter acesso ao Feed de Notícias para visualizá-lo.

Em `src/usuario` ficam as classes relacionadas principalmente ao Usuário, que são a partir dele pela rede social.
- `usuario/Atributo.java` O atributo de um usuário, que guarda nome e descrição;
- `usuario/PseudoUser` Solução (de nome ruim) para representar usuários de forma simplificada. Trata-se de uma superclasse que guarda o login e o nome do usuário. Ela é usada, por exemplo, para representar os membros de uma comunidade e o autor de uma publicação;
- `usuario/Amigo.java` Subclasse de `PseudoUser`. Representa os amigos de um usuário. Dentro dele ficam as mensagens;
- `usuario/Mensagem.java` As mensagens da rede social, com autor e conteúdo.
- `usuario/Solicitacao/java` Sublcasse de `PseudoUser`, representa uma solicitação de amizade do iFace. Mostra a quantidade de amigos do solicitante.

# Exceções
Tratamento de Exceções no projeto: 
- **Geral**: Ao longo de toda a implementação, os menus foram tratados para que não seja possível inserir entradas diferentes de números e das opções disponíveis através da `NumberFormatException`. Nesses casos, o programa entra em loop até que uma entrada válida seja inserida. Além disso, entradas vazias ou constituídas apenas de espaços lançam exceções, sem interromper a execução do programa. Todas as exceções são tratadas com mensagens amigáveis ao usuário, sem indicações da linha onde o erro ocorreu nem nada do tipo.

- **Criação de conta**:
	- **Nome**: Caso o nome contenha números ou símbolos, a exceção `InvalidNameException` será lançada.
	- **Login**: Caso o login contenha espaços ou @, ou seja constituído exclusivamente de números, a exceção `InvalidLoginException` será lançada.
	- **Senha**: Caso a senha tenha menos de seis caracteres ou espaços, a exceção `InvalidPassowordException` será lançada.
	Em todos esses casos a função continua a ser executada até que uma entrada válida ou a entrada de cancelamento ("-1") seja inserida.

- **Login na conta**: Caso o usuário queira entrar com um login inexistente, a exceção `UserNotFoundException` é lançada. Caso insira um login existente mas insira uma senha que não corresponde, a exceção `WrongPassowordException` é lançada. Nesses casos a função é encerrada e o usuário não consegue completar o login.

- **Criação e edição de atributos**: Nomes de atributos não podem conter números, descrições não podem ser vazias. Na edição, caso o usuário insira um índice indisponível, a exceção `IndexOutOfBoundsException` é lançada e a edição é cancelada.

- **Envio de solicitação de amizades**: Caso não haja usuários disponíveis, a exceção `NoAvaliableUsersException` é lançada. Se, ao ver a lista de usuários, o usuário insere um índice indisponível, a exceção `IndexOutOfBoundsException` é lançada e o envio é cancelado.

- **Resposta de solicitação de amizades**: Caso não haja solicitações, a exceção `NoRequestsException` é lançada. Se, ao ver a lista de solicitações, o usuário insere um índice indisponível, a exceção `IndexOutOfBoundsException` é lançada e a resposta é cancelada.

- **Envio de mensagens**: Caso o usuário não tenha amigos, a exceção `NoFriendsException` é lançada. Se, ao ver a lista de amigos, o usuário insere um índice indisponível, a exceção `IndexOutOfBoundsException` é lançada e o envio é cancelado. Caso a mensagem seja uma string vazia ou só de espaços, a exceção `EmptyInputException` é lançada.

- **Criação de comunidade**: Convencionou-se que um usuário só pode criar uma comunidade. Assim, caso já tenha criado uma, se o usuário tentar criar outra a exceção `ComunityCreatedException` será lançada. Nomes e descrições são tratadas conforme explicitado acima.

- **Entrada em comunidade**: Caso não haja comunidades disponíveis, a exceção `NoComunitiesException` é lançada. Se, ao ver a lista de comunidades, o usuário insere um índice indisponível, a exceção `IndexOutOfBoundsException` é lançada e a operação é cancelada.

- **Publicação no feed**: O usuário não pode publicar textos vazios.

- **Visualização do feed e resumo da conta**: Ambas funções de leitura apenas, não há o que tratar aqui. O controle já é feito pelo programa.

- **Exclusão da conta**: Para confirmar a exclusão da conta, o usuário deve reinserir a sua senha. Caso insira uma senha inválida, a exceção `WrongPassowordException` é lançada e a operação é cancelada.

# Design Patterns
Code smells encontrados no projeto e a suas resoluções

## Large Class
A classe `IFace`, centro do projeto, ficou grande demais porque dentro dela havia, além das funcionalidades da rede social, todo o tratamento de entradas com exceptions e regras de negócio. 
### Padrão aplicado
**Extract Class**: A partir desses tratamentos de entrada criei uma classe abstrata, `Entrada`, na qual regras gerais estão definidas. Cada tipo de entrada na rede social é uma subclasse de `Entrada`, a saber: `Nome`, `Login`, `Senha` e `Texto`, cada uma com as próprias regras. Além de diminuir `IFace`, o tratamento das entradas do usuário ficou mais simples e padronizado.

## Long method
Com a criação da classe `Entrada`, todos os métodos que precisassem ler uma entrada do usuário repetiam o mesmo bloco de código:

    while(true) {
            try {
                System.out.print("Insira a [entrada]");
                entrada.setEntrada(sc.nextLine());
                break;
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            }
        }
Pois toda entrada precisa ser lida e tratada de forma amigável. 

## Padrão aplicado
**Extract Method**: Esse bloco todo virou o seguinte método: 
    
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

O primeiro parâmetro é uma `Entrada`. Faço, portanto, uso de polimorfismo para que cada tipo de entrada se comporte da forma adequada na função `setEntrada()`, isto é, cada uma considere as suas regras. O segundo parâmetro é uma string, na qual está o comando que se repete caso a entrada seja inválida ("Crie um login: ", por exemplo). Com isso, em vez de ter de repetir o bloco ao longo dos métodos, basta chamar essa função em uma linha.

# Switch Statement
A aplicação é executada através da classe `Interface`, onde está localizada a função `main`. Essa execução ocorria através de uma cadeia de `if-else`, um para cada opção disponível no menu (cerca de dezesseis).
## Padrão aplicado
**Command**: Criei a classe abstrata `Command`, da seguinte forma: 
    
    public abstract class Command {;
        public abstract boolean execute(IFace iFace);
        public abstract String successMsg();
        public abstract String failureMsg();
        
        public void titulo(String str) {
            System.out.println("-=-=- "+str+" -=-=-");
    }

Cada subclasse de `Command` é uma das opções do menu, então cada uma executa sua determinada função em `iFace` através da função `execute()`. Como a maior parte dessas operações retornam booleano de sucesso ou falha, defini que elas devem ter a função `successMsg()` e `failureMsg()`, que retornam as respectivas Strings.

Então, na classe `Interface`, defini dois ArrayLists do tipo `Command`: `unloggedIn` é preenchido com as classes de comandos do usuário não logado e `loggedIn` é preenchdido com os comandos do usuário logado. Assim, basta verificar se o usuário está logado e chamar no ArrayList respectivo a opção que ele escolheu, na função abaixo:

     public static void call(Command comando, IFace iface) {
        if (comando.execute(iface))
            System.out.println(comando.successMsg());
        else
            System.out.println(comando.failureMsg());
    }