
CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;


INSERT INTO owners (first_name, last_name, address, city, telephone)
VALUES ('John', 'Doe', '123 Main St', 'Anytown', '555-1234');

INSERT INTO owners (first_name, last_name, address, city, telephone)
VALUES ('Jane', 'Smith', '456 Elm St', 'Othertown', '555-5678');







