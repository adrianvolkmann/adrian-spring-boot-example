
CREATE TABLE IF NOT EXISTS Entitie_With_Json
(
   id uuid NOT NULL primary key,
   name varchar (100),
   jsonBField jsonb
);