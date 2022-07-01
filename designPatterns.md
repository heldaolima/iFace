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

### Padrão aplicado
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

