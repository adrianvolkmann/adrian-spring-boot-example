# adrian-spring-boot-example

Projeto implementando exemplos de varias tecnologias para servir de exemplo para futuras implementações e tambem aumentar produtividade do dia a dia.

Na pasta [DOCUMENTATION](https://github.com/adrianvolkmann/adrian-spring-boot-example/tree/main/DOCUMENTATION) existem mais arquivos de documentação.

### Naming convections

para o nome do projeto utilizamos o padrao Kebab Case.
Exemplo: kebab-case-example

este padrao é o mesmo utilizado nos projeto spring boot

### docker compose
Para rodar o comando abaixo é necessario ter o [docker desktop](https://www.docker.com/products/docker-desktop/) instalado;

```bash
docker-compose up -d
```
Uma imagem Docker Alpine é uma imagem leve baseada no Alpine Linux, uma distribuição minimalista projetada para ser pequena e eficiente.

### exception handler

criar classe para responder globalmente todas exceções lancadas na aplicação

criar classe com @ControllerAdvice

anotar o metodo com @ExceptionHandler(MethodArgumentNotValidException.class) para tratar a exception desejada

pendencia:
- implementar exemplos das exceptions mais comuns


### flyway

no projeto spring basta adicionar a dependencia e adicionar os arquivos em src/main/resources/db/migration

**nomenclatura usada  no flyway**

Escolhido a nomenclatura a seguir

**Vyyyy.MM.dd.HH.mm__descricao.sql**

No [link](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html) vc pode verificar o padrao da nomenclatura utilizada.

Exemplo:
V2024.07.18.11.55__pagination.sql

No caso optei em usar o Flyway executando em ordem. Com esta nomenclatura a data atual sempre sera o ultimo arquivo.

Implementado validação dos nomes dos arquivos de migration. Caso não passe na validação, o projeto spring boot falhará na inicialização.

**Sempre executar uma migration ao subir o projeto:**

- Criar um arquivo com o prefixo "R", porém so é executado quando o conteudo do arquivo é alterado. 
- Outra opção é adicionar um placeholder no arquivo SQL, como no exemplo abaixo, que utiliza um timestamp. Dessa forma, o conteúdo do script muda a cada execução, garantindo que a migração seja sempre aplicada. No entanto, o ponto negativo é que cada execução do script gera uma nova entrada na tabela de histórico do Flyway, acumulando dados desnecessários.

```sql
-- ${flyway:timestamp}
```

- Uma alternativa é a executação diramente via codigo.


Ferramenta para gerar dados mock https://www.mockaroo.com/

Ferramenta para testar regex: https://www.trackingplan.com/regex-tester


### translations
exemplos no pacote com.volkmann.adrian_spring_boot_example.translation

pendencia:
 - deve-se tratar traducao no back-end ou front-end, no frond-end é normal existir campos adicionais para serem traduzidos.
 
 
- existe padrao de nomenclatura para criar as chaves de tradução? 

### swagger

basta adicionar a dependencia **springdoc-openapi-starter-webmvc-ui**

o swagger estara disponivel em *http://server:port/context-path/swagger-ui.html*

pendencia:
- remover as entities do swagger

### paginação

implementação padrao usando spring

verificar pacote **com.volkmann.adrian_spring_boot_example.pagination**

### RECORD vs CLASS

[https://www.javaguides.net/2023/12/difference-between-class-and-record-in-java.html](https://www.javaguides.net/2023/12/difference-between-class-and-record-in-java.html)

The compiler automatically provides a public constructor, as well as implementations of equals(), hashCode(), and toString() methods based on the record components.

```java
public record User(Long id, String firstName, String lastName, String email) {}
```

### TIPOS DE DADOS SQL

TIPO ENUM

O campo VARCHAR ocupa mais espaço em comparação a um campo ENUM, que geralmente é armazenado internamente como inteiros. Para grandes conjuntos de dados, isso pode resultar em maior consumo de armazenamento e impacto na performance, especialmente se a coluna for frequentemente usada em consultas ou índices.

Quando ocorre uma violação da restrição CHECK, a mensagem de erro é genérica e pode não fornecer detalhes claros sobre o valor esperado. Com ENUM, as ferramentas de ORM e o próprio PostgreSQL costumam fornecer mensagens de erro mais específicas.

Quando usar cada abordagem

   Use VARCHAR com CHECK quando a flexibilidade é importante, e você precisa de uma solução que seja compatível com outros bancos de dados ou ferramentas, e onde alterações são frequentes.
    Use ENUM quando o conjunto de valores for estável, e você deseja a eficiência e o controle mais rígido oferecido pelo PostgreSQL, especialmente se performance e integridade forem críticas para a aplicação.




###criar exemplo completo funcional de persistencia, usando record, moddelmapper, validation api
//testar @Validated

###cadastrar global exceptions


Usar injeção de dependência via construtor em vez da anotação @Autowired diretamente em métodos ou campos é amplamente recomendado pelas seguintes razões:
1. Imutabilidade e Segurança

Quando as dependências são injetadas via construtor e combinadas com o modificador final, elas se tornam imutáveis após a inicialização da classe. Isso garante que as dependências não sejam alteradas acidentalmente ao longo do ciclo de vida da classe, o que aumenta a segurança e previsibilidade do código.

Exemplo:

java

public class ParentController {
    private final ParentEntityRepository parentRepository;
    private final ModelMapper modelMapper;

    public ParentController(ParentEntityRepository parentRepository, ModelMapper modelMapper) {
        this.parentRepository = parentRepository;
        this.modelMapper = modelMapper;
    }
}

Neste exemplo, após o objeto ParentController ser criado, parentRepository e modelMapper não podem ser modificados.
2. Facilidade para Testes (Testabilidade)

A injeção por construtor facilita a escrita de testes unitários, pois as dependências podem ser facilmente passadas (mockadas ou não) durante a criação do objeto, sem necessidade de frameworks como o Spring estar rodando.

java

ParentController controller = new ParentController(mockRepository, mockModelMapper);
// Teste facilmente o comportamento do controller

Se você usar @Autowired nos campos, isso pode exigir o uso do contexto do Spring para injeção, o que torna o teste mais complexo e depende do framework para funcionar.
3. Eliminação de Dependências Ocultas

Com a injeção por construtor, todas as dependências da classe são claramente expostas na assinatura do construtor. Isso torna o código mais fácil de ler, pois quem desenvolve ou mantém o código pode ver claramente de quais dependências a classe precisa.

Quando você usa @Autowired nos campos, essas dependências podem ficar "escondidas", dificultando o entendimento do que a classe realmente necessita para funcionar.
4. Evita Problemas com Injeção de Dependência Tardia

A injeção por construtor garante que todas as dependências estejam resolvidas antes do objeto ser criado. Já o @Autowired em campos ou métodos pode resultar em dependências sendo injetadas após o objeto ser parcialmente inicializado, o que pode causar problemas se o objeto depender dessas injeções para funcionar adequadamente em seu estado inicial.
5. Compatibilidade com final

Quando você usa injeção por construtor, pode marcar as dependências como final, o que torna claro que essas dependências não mudarão durante o ciclo de vida do objeto. Isso não é possível quando se usa @Autowired diretamente nos campos.

java

public class ParentController {
    private final ParentEntityRepository parentRepository;

    public ParentController(ParentEntityRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
}

6. Princípio da Inversão de Controle (IoC)

A injeção por construtor adere melhor ao princípio da inversão de controle, garantindo que o objeto não gerencie suas próprias dependências, mas as receba como parâmetros externos. Isso dá mais controle ao código externo (como o Spring) e ao próprio desenvolvedor para decidir como e quando essas dependências serão fornecidas.
7. Menos Erros em Execução

Quando você utiliza @Autowired diretamente em campos, pode ocorrer que a injeção falhe silenciosamente se as dependências não estiverem configuradas corretamente, sem erros explícitos no momento da inicialização. Com injeção por construtor, o código falhará imediatamente se as dependências obrigatórias não forem fornecidas.
8. Construtores Padrões e Obrigatoriedade

Ao usar injeção por construtor, você tem controle sobre quais dependências são obrigatórias, garantindo que a classe sempre tenha as injeções necessárias para operar. Com @Autowired, é possível que o Spring injete null em dependências opcionais, o que pode levar a falhas em tempo de execução se não houver verificações adicionais.
9. Código Mais Limpo

Ao usar injeção por construtor, o código tende a ser mais limpo e menos acoplado ao framework, uma vez que você não depende diretamente da anotação @Autowired em cada campo ou método.
Exemplo Comparativo:
Injeção por Construtor (Recomendada):

java

public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    // métodos da classe...
}

Injeção por @Autowired (Menos recomendada):

java

public class MyService {
    @Autowired
    private MyRepository repository;

    // métodos da classe...
}

Embora o segundo exemplo funcione, ele perde os benefícios descritos anteriormente, como imutabilidade, facilidade de teste, clareza de dependências e segurança.
Conclusão

Usar injeção de dependências via construtor é considerado uma prática recomendada por tornar o código mais claro, seguro, testável e imutável, além de seguir princípios sólidos de design como o SOLID e o IoC (Inversão de Controle).


