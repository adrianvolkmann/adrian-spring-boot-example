CREATE TABLE IF NOT EXISTS sql_types
(
   id uuid NOT NULL primary key,
   campo_integer integer,
   campo_float real,
   campo_double DOUBLE PRECISION,
   campo_boolean boolean,
   campo_varchar_limitado varchar (100),
   campo_varchar varchar,
   campo_local_date date,
   campo_local_time time,
   campo_local_date_time timestamp,
   campo_date_time_zoned timestamptz,
   campo_jsonb jsonb
);
--adionar validacao de valores enum