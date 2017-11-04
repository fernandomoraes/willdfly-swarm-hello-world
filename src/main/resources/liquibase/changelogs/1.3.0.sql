--liquibase formatted sql

--changeset fernandosm:1
CREATE TABLE STATUS_CHECK (
  ID INT8 NOT NULL,
  STATUS VARCHAR(255) NOT NULL,
  CHECKED_IN TIMESTAMP NOT NULL,
  CONSTRAINT PK_STATUS_CHECK PRIMARY KEY (ID)
);
--rollback DROP TABLE STATUS_CHECK;

--changeset fernandosm:2
GRANT ALL ON STATUS_CHECK TO swarm_hello_world_system;
--rollback not required;

--changeset fernandosm:3
CREATE SEQUENCE STATUS_CHECK_SEQUENCE START 1 INCREMENT 1;
--rollback DROP SEQUENCE STATUS_CHECK_SEQUENCE;

--changeset fernandosm:4
GRANT ALL ON STATUS_CHECK_SEQUENCE TO swarm_hello_world_system;
--rollback not required;

