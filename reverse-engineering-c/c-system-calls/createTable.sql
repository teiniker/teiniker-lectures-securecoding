CREATE TABLE User 
( 
    id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    username VARCHAR(64) NOT NULL,
    password VARCHAR(256) NOT NULL
);


INSERT INTO User (username, password) VALUES ('homer', '*******');
INSERT INTO User (username, password) VALUES ('bart', '*******');
INSERT INTO User (username, password) VALUES ('lisa', '*******');


