CREATE SEQUENCE device_sequence start 5 increment 1;
CREATE TABLE IF NOT EXISTS device(
id int8 PRIMARY KEY NOT NULL,
date_release date,
supervisior varchar(100),
factory_id int8 REFERENCES factory(id));