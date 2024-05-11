CREATE TABLE IF NOT EXISTS Pessoa
(
   id uuid NOT NULL primary key ,
   name varchar (100)
) ;



CREATE TABLE IF NOT EXISTS Endereco
(
   id uuid NOT NULL primary key,
   apelido varchar (100),
   rua varchar (100),
   cep varchar (100),
   pessoa_id uuid references Pessoa(id)
);