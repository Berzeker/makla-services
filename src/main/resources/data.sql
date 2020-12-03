DROP TABLE IF EXISTS RESTAURANTS;

CREATE TABLE RESTAURANTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(500) NOT NULL,
  score INT NULL
);

INSERT INTO RESTAURANTS (name, address, score) VALUES ('MCDO', 'Kénitra', 7); 
INSERT INTO RESTAURANTS (name, address, score) VALUES ('Pinchos', 'Rabat', 6); 