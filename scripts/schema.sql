CREATE TABLE IF NOT EXISTS types (
  id SERIAL PRIMARY KEY,
  name VARCHAR(80)
);

CREATE INDEX IF NOT EXISTS types_name_index ON types (name);

CREATE TABLE IF NOT EXISTS owners (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20)
);

CREATE INDEX IF NOT EXISTS owners_last_name_index ON owners (last_name);

CREATE TABLE IF NOT EXISTS pets (
  id SERIAL PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT NOT NULL REFERENCES types(id),
  owner_id INT REFERENCES owners(id)
);

CREATE INDEX IF NOT EXISTS pets_name_index ON pets (name);