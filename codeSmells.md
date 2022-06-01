# Speculative Generality
As seguintes interfaces não são implementadas por mais de uma classe:
- `Feed.java`
- `Perfil.java`
- `RedeSocial.java`

# Data Class
As seguintes classes têm apenas atributos, getters e setters:
- `Comunidade.java`: falta um método que liste os membros da classe
- `Publicação.java`;
- `Atributo.java`;
- `Mensagem.java`;
- `PseudoUser.java;`
- `Solicitação.java`;

# Long Method
- `IFace.editarAtributo()`;
- `IFace.enviarMensagem()`;
- `IFace.publicarNoFeed()`;
- `IFace.excluirConta()`: variáveis temporárias em excesso;
- `Usuario.resumoDaConta()`;

# Large Class
- `Usuario.java`
- `IFace.java`;

# Duplicated Code
Reparei que em todas as funções de leitura, após o tratamento de exceções, repetem-se certas estruturas e funções.
- A função `IFace.lerNome()`, aninhada dentro de uma estrutura `try_catch`, repete-se nas seguintes funções: 
    - `IFace.novoAtributo()`
    - `IFace.editarAtributo()`
    - `IFace.novaComunidade()`
- A função `IFace.lerTexto()`, aninhada dentro de uma estrutura `try_catch`, repete-se nas seguintes funções:
    - `IFace.novoAtributo()`
    - `IFace.editarAtributo()`
    - `IFace.enviarMensagem()`
    - `IFace.novaComunidade()`
    - `IFace.publicarNoFeed()`
    - `IFace.novaComunidade()`
- O seguinte bloco se repete em cada função em que é preciso ler um número do usuário, geralmente para representar suas escolhas:

        int i;
            while (true) {
                try {
                    i = Integer.parseInt(sc.nextLine());
                    i = i-1;
                    break;
                } catch(NumberFormatException e) {
                    System.err.println("Entrada inválida! Por favor, insira um número");
                }
            }

- Há uma idêntica a essa, exceto que ela verifica se `i` está dentro dos limites do menu, e que também se repete em quase todas as funções, assim: 

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

# Long Parameter List
- A função construtora de `Logado.java`: 

        public Logado(String nome, String login, String senha, ArrayList<Amigo> amigos, 
        ArrayList<Solicitacao> solicitacoes, 
        Comunidade comunidade,  ArrayList<String> comunidadesMembro, ArrayList<Atributo> atributos) {

# Divergent changes
- Quase sempre que mudo algo no código, preciso mudar `IFace.java` e `Usuario.java`, e é inevitável que eu precise mudar as interfaces que elas implementam.

# Lazy Class
- Após entrar em contato com o conceito, fiquei em dúvida quanto à utilidade da classe `logado.java`, pois é a única que extende `Usuario.java` e faz pouco além do que esta, é mais uma espécie de regra (apenas o logado faz tal coisa).

# Middle Man
- Edição de atributos em `Logado.editarAtributoNome()` e `logado.editarAtributoDescricao()`: ele apenas chama o setter de `Atributo`;
- `Usuario.comunidadeToString()`: apenas chama o `toString()` de `Comunidade`.

# Refused Bequest
- `Logado` herda todos os métodos de `Usuario`, sendo uma subclasse deste, porém não os usa em nenhum momento.