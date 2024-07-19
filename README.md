# adrian-spring-boot-example

Projeto implementando exemplos de varias tecnologias para servir de exemplo para futuras implementações e tambem aumentar produtividade do dia a dia.

Na pasta [DOCUMENTATION](https://github.com/adrianvolkmann/adrian-spring-boot-example/tree/main/DOCUMENTATION) existem mais arquivos de documentação.

###Naming convections

para o nome do projeto utilizamos o padrao Kebab Case.
Exemplo: kebab-case-example

este padrao é o mesmo utilizado nos projeto spring boot

### docker compose
Para rodar o comando abaixo é necessario ter o [docker desktop](https://www.docker.com/products/docker-desktop/) instalado;

```bash
docker-compose up -d
```
pendencia:
- descrever oq eh imagem alpine

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

Ferramenta para gerar dados mock https://www.mockaroo.com/

pendencia:
- implementar validacao de nomenclatura dos arquivos ao subir o projeto
https://stackoverflow.com/questions/62953092/how-to-programmatically-trigger-flyway-migration-before-spring-boot-flyway-ootb

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




