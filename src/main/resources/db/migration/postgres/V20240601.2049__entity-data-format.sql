
CREATE TABLE IF NOT EXISTS date_format
(
   id uuid NOT NULL primary key,
   local_date_time timestamp,
   local_date date,
   local_time time,
   zoned_date_time timestamptz
);