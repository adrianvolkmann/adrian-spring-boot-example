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





