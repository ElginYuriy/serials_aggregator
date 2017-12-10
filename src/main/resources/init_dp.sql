/*
--create user elgin IDENTIFIED by root
--default  TABLESPACE users quota 100M on USERS;
--/
grant create session to elgin;
/
grant create table to elgin;
/
grant create trigger to elgin;
/
grant create sequence to elgin;
/
grant alter any table to elgin;
/
grant delete any table to elgin;
/
grant drop any table to elgin;
/
*/

CREATE TABLE elgin.serials (
  serial_id   number NOT NULL,
  name        VARCHAR2(255) NOT NULL,
  origin_name VARCHAR2(255),
  prod_years  VARCHAR2(20),
  genre       VARCHAR2(255),
  seasons     NUMBER,
  CONSTRAINT pk_serials PRIMARY KEY (serial_id)
) TABLESPACE USERS;
/
CREATE INDEX ELGIN.SERIALS_NAME_INDX ON SERIALS(NAME);
/
CREATE SEQUENCE hibernate_sequence
START WITH 100 INCREMENT BY 1 NOMAXVALUE;