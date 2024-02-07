CREATE SEQUENCE factory_sequence start 3 increment 1;
CREATE TABLE IF NOT EXISTS factory(
id int8 PRIMARY KEY NOT NULL,
name varchar(100),
address varchar(150),
date_construction date,
date_addition date);