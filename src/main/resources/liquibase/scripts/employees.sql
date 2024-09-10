-- liquibase formatted sql

-- changeset dporoshin:1

CREATE TABLE employees(
    id           INTEGER PRIMARY KEY,
    nick         VARCHAR(60) UNIQUE NOT NULL,
    first_name   VARCHAR(30),
    last_name    VARCHAR(30),
    surname      VARCHAR(30),
    password     VARCHAR(30),
    role         VARCHAR(20) UNIQUE

);

-- changeset dporoshin:2

INSERT INTO employees VALUES (
                              1, 'admin', 'admin', 'admin', 'admin', 'admin', 'ADMIN'
                             );
