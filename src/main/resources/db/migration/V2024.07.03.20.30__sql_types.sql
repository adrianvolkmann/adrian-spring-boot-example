CREATE TYPE enum_field AS ENUM ('ACTIVE', 'INACTIVE', 'PENDING');
--ALTER TYPE status_enum ADD VALUE 'SUSPENDED';

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
   campo_jsonb jsonb,
   campo_enum enum_field,
   campo_enum_string VARCHAR(20),
   CONSTRAINT campo_enum_string_check CHECK (campo_enum_string IN ('ACTIVE', 'INACTIVE', 'PENDING'))
);

--ALTER TABLE users DROP CONSTRAINT status_check;
--ALTER TABLE users ADD CONSTRAINT status_check CHECK (status IN ('ACTIVE', 'INACTIVE', 'PENDING', 'SUSPENDED'));

