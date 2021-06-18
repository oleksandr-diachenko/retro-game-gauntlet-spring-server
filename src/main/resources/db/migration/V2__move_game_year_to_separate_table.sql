CREATE SEQUENCE year_seq
    MINVALUE 1
    START WITH 1050
    INCREMENT BY 50;

CREATE TABLE year
(
    id   BIGINT,
    year NUMBER NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE game
    ADD COLUMN year_id NUMBER NOT NULL;

ALTER TABLE game
    ADD CONSTRAINT fk_year_id
        FOREIGN KEY (year_id)
            REFERENCES year (id);

ALTER TABLE game DROP COLUMN year;

