### Nomenclatura utilizada nos arquivos SQL

Bom guia para nomear/formatar SQLS: [https://www.sqlstyle.guide/](https://www.sqlstyle.guide/)

**exemplo de SQL formatado**

```sql
CREATE TABLE IF NOT EXISTS Pagination
(
   id UUID NOT NULL primary key ,
   name VARCHAR (100),
   idade  INTEGER,
   data_nascimento DATE
) ;
```

- Usar letras maiusculas para palavras reservadas como SELECT.
- Usar letras minusculas para identificadores.
- terminar cada comando com ;
- nomes de tabelas e colunas sempre no singular.
- Datas sempre gravar menos informação possivel date>time>timestamp