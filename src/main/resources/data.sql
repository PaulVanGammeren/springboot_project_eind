


INSERT INTO users (username, password, email, enabled) VALUES ('user', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'paul@natureskins.nl', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('admin', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'paul@gmail.com', TRUE);
INSERT INTO users (username, password, email, enabled) VALUES ('charlotte', '$2a$12$3oNi58/TccIhzvqS92hUWu1RrPSL2P2wtLUJyu8vNlSi71LTWke3C', 'charlotte@gmail.com', TRUE);

INSERT INTO authorities(username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('charlotte', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('admin', 'ROLE_ADMIN');

-- herkent Username niet, werkt wel
INSERT INTO consult(advice, id, username) VALUES('dit is advies 1 van onze schoonheidsspecialiste', 1001, 'user');
INSERT INTO consult(advice, id, username)  VALUES('dit is advies 2 van onze huidspecialiste', 1002, 'user');


--INSERT INTO products(price, product_name) VALUES (24, 'dagcreme');
--INSERT INTO products(price, product_name) VALUES (12, 'nachtcreme');
--INSERT INTO products(price, product_name) VALUES (19, 'toner');

