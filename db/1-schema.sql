CREATE TABLE IF NOT EXISTS products (
  id SERIAL PRIMARY KEY,
  name VARCHAR (256) NOT NULL,
  department VARCHAR (256) NOT NULL,
  description VARCHAR (1024),
  price NUMERIC(8, 2),
  image VARCHAR (256),
  released_at VARCHAR (256) NOT NULL
);
