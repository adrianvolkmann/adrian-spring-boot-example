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

CREATE TABLE IF NOT EXISTS Employee
(
   id uuid NOT NULL primary key ,
   name varchar (100)
) ;

CREATE TABLE IF NOT EXISTS Project
(
   id uuid NOT NULL primary key ,
   title varchar (100)
) ;

CREATE TABLE IF NOT EXISTS Employee_Project
(
   employee_id uuid references Employee(id),
   project_id uuid references Project(id)
) ;