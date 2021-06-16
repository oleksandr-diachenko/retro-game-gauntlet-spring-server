CREATE SEQUENCE console_seq
    MINVALUE 1
    START WITH 1050
    INCREMENT BY 50;

CREATE TABLE console
(
    id   BIGINT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE game_seq
    MINVALUE 1
    START WITH 1050
    INCREMENT BY 50;

CREATE TABLE game
(
    id         BIGINT,
    name       VARCHAR(255) NOT NULL,
    year       INTEGER(4) NOT NULL,
    console_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (console_id) REFERENCES console (id)
)