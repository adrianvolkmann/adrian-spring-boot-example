# adrian-spring-boot-example

Naming convections

para o nome do projeto utilizamos o padrao Kebab Case.
Exemplo: kebab-case-example

este padrao é o mesmo utilizado nos projeto spring boot

convensoes nomes java
https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html

camelCase para variáveis, atributos e métodos

PascalCase para classes, enum e interfaces

SCREAMING_SNAKE_CASE para constantes

packages com.example.demo

# tecnologias utilizadas
modell maper

exception handler

biblioteca swagger

profiles/properties


Ferramenta para gerar SQL para gerar dados https://www.mockaroo.com/


properties por perfil, 


fazer todos endpoints responder com type json etc

validation


relacionamento entidades/eagear leazy


# docker compose
Para rodar o comando abaixo é necessario ter o [docker desktop](https://www.docker.com/products/docker-desktop/) instalado;

```bash
docker-compose up -d
```

descrever oq eh imagem alpine



nomenclatura usada  no flyway

Escolhido a nomenclatura a seguir
Vyyyy.MM.dd.HH.mm__descricao.sql

No link vc pode verificar o padrao da nomenclatura utilizada.
https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

Exemplo:
V2024.07.18.11.55__pagination.sql

No caso optamos em usar o Flyway executando em ordem. Com esta nomenclatura a data atual sempre sera o ultimo arquivo.

falta implementar validacao de nomenclatura ao subir o projeto



criacao do swagger
springBoot Actuator
record vs class (toString, metodos default)
translations
properties com perfil
classe exemplo todas validations
classe todos tipos de dados do postgrees

separacao das pacotes por Domain Driven

docker compose

juntei aqui os exemplos do memcached
ajustar documento que descreve padrao de nomenclatura

ciar pasta para armazenar os MD

