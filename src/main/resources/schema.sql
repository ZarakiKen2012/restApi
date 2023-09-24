DROP TABLE IF EXISTS persons_roles;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS roles;
CREATE TABLE persons
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    first_Name VARCHAR(255) NOT NULL,
    lastName  VARCHAR(255) NOT NULL,
    age       int          NOT NULL,
    password  VARCHAR(255) NOT NULL
);

CREATE TABLE roles
(
    id   int PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE persons_roles
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    person_id int NOT NULL,
    role_id   int NOT NULL
)