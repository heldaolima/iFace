# Projeto P2 - Rede de relacionamentos
Trata-se da implementação de um sistema que mantém uma rede de relacionamentos, semelhante a uma rede social.

## Instruções de execução
É no arquivo `src/Interface.java` que a rede funciona. É preciso que ele seja executado a partir da pasta do projeto, e não de dentro de `src`.

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

## Notas sobre a implementação
### Atributos
Interpretei que Atributo na rede social é uma característica que o usuário escolhe mostrar a seu respeito. Por exemplo, o atributo "Trabalho" com a descrição "Sou engenheiro de Software na empresa X".

### Comunidades
No momento, cada usuário é capaz de criar apenas uma comunidade. 

### Conceitos de Programação Orientada a Objetos
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