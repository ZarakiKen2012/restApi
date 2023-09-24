INSERT INTO persons (first_Name, lastName, age, password) VALUES ('Bob', 'jj', 22, '123325');
INSERT INTO persons (first_Name, lastName, age, password) VALUES ('Bob2', 'jj', 33, '123325');
INSERT INTO persons (first_Name, lastName, age, password) VALUES ('Bob3', 'jj', 33, '123325');

INSERT INTO roles (role) VALUES ('ADMIN');
INSERT INTO roles (role) VALUES ('USER');

INSERT INTO persons_roles (person_id, role_id) VALUES (1, 1);
INSERT INTO persons_roles (person_id, role_id) VALUES (1, 2);
INSERT INTO persons_roles (person_id, role_id) VALUES (2, 2);
INSERT INTO persons_roles (person_id, role_id) VALUES (3, 2);