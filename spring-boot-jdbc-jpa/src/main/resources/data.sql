-- This is run when the h2 database is created
-- You can see the database at /h2-console
CREATE TABLE person
(
    id int not null,
    name varchar(255) not null,
    location varchar(255),
    primary key(id)
);

INSERT INTO person (id, name, location)
VALUES (100001, 'Michel', 'Piata Unirii');

INSERT INTO person (id, name, location)
VALUES (100002, 'Pascal', 'Sag');

INSERT INTO person (id, name, location)
VALUES (100003, 'Jeff', 'Libertatii');