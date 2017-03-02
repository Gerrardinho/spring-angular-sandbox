INSERT INTO spring_angular.authority (authority) VALUES ('ROLE_USER');
INSERT INTO spring_angular.authority (authority) VALUES ('ROLE_ADMIN');

INSERT INTO spring_angular.user (email, first_name, last_name, password, username) VALUES ('gerardo.lopezre@gmail.com', 'Gerardo', 'López', '$2a$10$coZSzhHIxYYBp7UcMJZEAeNvVyW8z43hvXlxhrk7eKKapE.p7dZ56', 'gerardo8');
INSERT INTO spring_angular.user (email, first_name, last_name, password, username) VALUES ('lli-el@hotmail.com', 'Gerardo', 'López', '$2a$10$coZSzhHIxYYBp7UcMJZEAeNvVyW8z43hvXlxhrk7eKKapE.p7dZ56', 'gerardinho');

INSERT INTO spring_angular.user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO spring_angular.user_authority (user_id, authority_id) VALUES (1, 2);
INSERT INTO spring_angular.user_authority (user_id, authority_id) VALUES (2, 1);
