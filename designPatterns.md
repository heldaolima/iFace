# Design Patterns
Code smells encontrados no projeto e a sua resolução

## Large Class
A classe `IFace`, centro do projeto, ficou grande demais porque dentro dela havia, além das funcionalidades da rede social, todo o tratamento de entradas com exceptions e regras de negócio. 
### Padrão aplicado
**Extract Class**: A partir desses tratamentos de entrada criei uma classe abstrata, `Entrada`, na qual defino as regras para as entradas. Cada tipo de entrada na rede social é uma subclasse de `Entrada`, a saber: `Nome`, `Login`, `Senha` e `Texto`. Além de diminuir `IFace`, o tratamento das entradas do usuário ficou mais simples e padronizado.