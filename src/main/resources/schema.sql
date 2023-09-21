DROP TABLE IF EXISTS person_role;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS roles;
CREATE TABLE person
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

CREATE TABLE person_role
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    person_id int NOT NULL,
    role_id   int NOT NULL
)