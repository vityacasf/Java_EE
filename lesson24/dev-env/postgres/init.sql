CREATE TABLE usersInNetwork
(
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

INSERT INTO usersInNetwork (login, password) VALUES ('Vityacasf', '3214');

