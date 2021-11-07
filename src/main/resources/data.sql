INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'paul@natureskins.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('paul', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'paul@gmail.com', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('charlotte', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'charlotte@gmail.com', TRUE);

INSERT INTO authorities(username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('paul', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('charlotte', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('paul', 'ROLE_ADMIN');
INSERT INTO authorities(username, authority) VALUES ('charlotte', 'ROLE_ADMIN');


INSERT INTO customers(first_Name, last_Name, e_Mail) VALUES('nova', 'eeken', 'nova@gmail.com');
INSERT INTO customers(first_Name, last_Name, e_Mail) VALUES('dania', 'dohrman', 'dania@gmail.com');
INSERT INTO customers(first_Name, last_Name, e_Mail) VALUES('annelies', 'borst', 'annelies@gmail.com');
INSERT INTO customers(first_Name, last_Name, e_Mail) VALUES('paul', 'van gammeren', 'paul@natureskins.com');

INSERT INTO products(price, product_name) VALUES (24, 'dagcreme');
INSERT INTO products(price, product_name) VALUES (12, 'nachtcreme');
INSERT INTO products(price, product_name) VALUES (19, 'toner');

INSERT INTO consult(advies) VALUES('dit is advies 1 van onze schoonheidsspecialiste');
INSERT INTO consult(advies) VALUES('dit is advies 2 van onze huidspecialiste');